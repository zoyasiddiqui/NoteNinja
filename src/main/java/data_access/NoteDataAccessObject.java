package data_access;

import entity.Note.Note;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.search_notes.SearchNotesAccessInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

// TODO: we currently rely on the root/notes folder already having been created by the user.
// TODO: make it so that we first check if the folder exists and if it does not, the code creates one
// TODO: this way our program will not rely on users having properly instantiated the folders by themselves
// TODO: if u guys (zoro) dont have time, then ill just do it myself (dandelion)

public class NoteDataAccessObject implements CreateNoteDataAccessInterface,
        EditNoteDataAccessInterface, DeleteNoteDataAccessInterface, SearchNotesAccessInterface {

    private static final Map<Note, File> allNotes = new HashMap<>();
    private static Note currentNote;
    private int tempNoteCount; // delete this after implementing getNoteCount() and incrementNoteCount()

    @Override
    public void create(Note note) throws IOException {
        tempNoteCount++;
//        this.incrementNoteCount(); // implement this!!

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
        // TODO: create a file in notes, notes/data.csv, which holds the number of notes created as an integer value
        // TODO: the data.csv file will only contain 1 integer entry, representing the NoteCount
        // TODO: if the file does not exist (it wont for first time), create it and set the integer value to 0, then return this 0 value
        // TODO: if the file already exists, read the value from it and return it
        return tempNoteCount; // temporary attribute value for one-run testing. we lose this value after stopping program; hence the entire reason we must add a data.csv file for persistence
    }

    @Override
    public void incrementNoteCount() {
        // TODO: see above todos. call getNoteCount() and add 1 to it then write the incremented value to the data.csv
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
            System.out.println(noteText);
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
