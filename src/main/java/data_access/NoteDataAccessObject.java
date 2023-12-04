package data_access;

import entity.Note.CommonNoteFactory;
import entity.Note.Note;
import entity.Note.NoteFactory;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.search_notes.SearchNotesAccessInterface;

import java.io.*;
import java.util.*;

public class NoteDataAccessObject implements
        CreateNoteDataAccessInterface,
        EditNoteDataAccessInterface,
        DeleteNoteDataAccessInterface,
        SearchNotesAccessInterface {

    private static final Map<Note, File> allNotes = new HashMap<>();
    private static Note currentNote;

    public NoteDataAccessObject() {

        //setup allNotes using the file we have, if necessary
        String filePath = "notes/allNotes.csv";
        File file = new File(filePath);

        if (file.exists()) {

            try {
                BufferedReader r = new BufferedReader(new FileReader(filePath));

                String l;
                String text = "";
                while ((l = r.readLine()) != null) {

                    String[] split = l.split(":");
                    String noteName = split[1];
                    Integer noteID = Integer.parseInt(split[2]);
                    BufferedReader r2 = new BufferedReader(new FileReader(split[0]));

                    String a;
                    while ((a = r2.readLine()) != null) {
                        text += a;
                    }

                    NoteFactory noteFactory = new CommonNoteFactory();
                    Note note = noteFactory.create(noteName, text, noteID);

                    allNotes.put(note, new File(split[0]));

                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void create(Note note) throws IOException {
        this.setNoteCount(this.getNoteCount() + 1); // increases the note count by 1

        // setting the ID of note most recently accessed
        int noteNumber = note.getID();

        // updating variables so we can more easily edit the note
        currentNote = note;

        File noteFile = new File("notes/note"+ noteNumber +".csv");
        allNotes.put(note, noteFile);

        //updating the note in the csv file
        this.updateNote(note.getID(), note.getText(), note.getName());
        this.updateAllNotesFile();

    }

    /*
    This method updates the file holding the information about all of the notes
     */
    private void updateAllNotesFile() {
        String allNotesPath = "notes/allNotes.csv";
        File allNotesFile = new File(allNotesPath);

        if (!allNotesFile.exists()) {
            try{
                allNotesFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Set<Note> noteSet = allNotes.keySet();
            BufferedWriter w = new BufferedWriter(new FileWriter(allNotesFile));

            for (Note n : noteSet) {
                String notePath = allNotes.get(n).getPath();
                w.write(notePath + ":" + n.getName() + ":" + n.getID());
                w.newLine();
            }

            w.flush();
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getNoteCount() {
        String dataPath = "notes/data.csv";
        File file = new File(dataPath); // create File object for the specified path
        file.getParentFile().mkdirs(); // create parent directories if they don't exist

        // create data.csv file if it doesn't exist
        if (!file.exists()) {
            try {
                file.createNewFile();

                // write "0" into the first line of data.csv when we create it for the first time
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write("0");
                    writer.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String noteCount = null;
        try (BufferedReader br = new BufferedReader(new FileReader(dataPath))) {
            noteCount = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert noteCount != null;
        return Integer.parseInt(noteCount); // temporary attribute value for one-run testing. we lose this value after stopping program; hence the entire reason we must add a data.csv file for persistence

    }

    @Override
    public void setNoteCount(int count) {
        String noteCount = String.valueOf(count);
        String dataPath = "notes/data.csv";
        File file = new File(dataPath);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(noteCount);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Note note) throws IOException {

        try {
            Set<Note> noteSet = allNotes.keySet();
            Note toDelete = null;
            for (Note curNote : noteSet) {
                if (note.getID() == curNote.getID()) {
                    //emptying the file
                    toDelete = curNote;
                }
            }

            this.removeNote(note.getID());
//             removing from list of notes
            allNotes.remove(toDelete);

        } catch (NullPointerException e) {
            return;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.updateAllNotesFile();
    }

    private void removeNote(int noteID) throws Exception {
        String dataPath = "notes/note" + noteID + ".csv";
        File file = new File(dataPath);
        if (file.exists()) {
            try {
                if (file.delete()) {
                    System.out.println("File deleted successfully.");
                } else {
                    System.err.println("Unable to delete the file (delete returned false).");

                    // Additional prints for debugging
                    System.err.println("File path: " + file.getAbsolutePath());
                    System.err.println("File canRead: " + file.canRead());
                    System.err.println("File canWrite: " + file.canWrite());
                    System.err.println("File isFile: " + file.isFile());

                    // Print the stack trace to get more details about the exception
                    // This will help identify the specific issue preventing the deletion
                }
            } catch (SecurityException e) {
                System.err.println("SecurityException: Unable to delete the file. Check permissions.");
                e.printStackTrace();
            } catch (Exception e) {
                System.err.println("Exception while deleting the file.");
                e.printStackTrace();
            }
        } else {
            System.err.println("File does not exist.");
        }
    }

    @Override
    public Note getNoteById(int noteId) {
        Set<Note> noteSet = allNotes.keySet();
        for (Note curNote: noteSet) {
            if (curNote.getID() == noteId) {
                return curNote;
            }
        }
        return null;
    }

    @Override
    public boolean existsByID(int noteID) {

        Set<Note> noteSet = allNotes.keySet();

        for (Note curNote: noteSet) {
            if (curNote.getID() == noteID) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateNote(int noteID, String noteText, String noteTitle) throws IOException {

        //find the correct note and then find the correct file
        File fileToEdit = null;
        Set<Note> noteSet = allNotes.keySet();
        for (Note n : noteSet) {
            if (n.getID() == noteID) {
                currentNote = n;
                fileToEdit = allNotes.get(n);
            }
        }

        //write to the file
        if (fileToEdit == null) {
            return;
        }
        else {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileToEdit));
            writer.write(noteText);
            writer.newLine();
            writer.flush();
            writer.close();

            currentNote.setText(noteText);
            currentNote.setID(noteID);
            currentNote.setName(noteTitle);
        }

        this.updateAllNotesFile();

    }

    @Override
    public String getCurrentText() {
        return currentNote.getText();
    }

    @Override
    public void setCurrentText(String text) {
        currentNote.setText(text);
    }

    @Override
    public Note findByTitle(String noteTitle) {
        Set<Note> noteSet = allNotes.keySet();

        for (Note n : noteSet) {
            if (n.getName().equals(noteTitle)) {
                return n;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Note> getNotes() {
        return new ArrayList<>(allNotes.keySet());
    }
}
