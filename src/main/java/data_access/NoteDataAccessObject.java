package data_access;

import entity.Note.Note;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.search_notes.SearchNotesAccessInterface;

import java.io.*;
import java.util.*;

public class NoteDataAccessObject implements CreateNoteDataAccessInterface,
        EditNoteDataAccessInterface, DeleteNoteDataAccessInterface, SearchNotesAccessInterface {

    private static final Map<Note, File> allNotes = new HashMap<>();
    private static Note currentNote;

    @Override
    public void create(Note note) throws IOException {
        this.incrementNoteCount(); // implement this!!

        // setting the ID of note most recently accessed
        int noteNumber = note.getID();

        File noteFile = new File("notes/note"+ noteNumber +".csv");

        // updating variables so we can more easily edit the note
        currentNote = note;
        allNotes.put(note, noteFile);

        this.updateNote(note.getID(), note.getText(), note.getName());
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
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataPath))) {
                    writer.write("0");

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
    public void incrementNoteCount() {
        String noteCount = String.valueOf(this.getNoteCount() + 1);
        String dataPath = "notes/data.csv";
        File file = new File(dataPath); // create File object for the specified path

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataPath))) {
            writer.write(noteCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Note note) throws IOException {

        try {
            Set<Note> noteSet = allNotes.keySet();
            for (Note curNote : noteSet) {
                if (note.getID() == curNote.getID()) {
                    //emptying the file
                    this.updateNote(note.getID(), "", note.getName());

                    // removing from list of notes
                    allNotes.remove(curNote);
                }
            }
        } catch (NullPointerException e) {
            return;
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
            writer.close();

            currentNote.setText(noteText);
            currentNote.setID(noteID);
            currentNote.setName(noteTitle);
        }
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
}
