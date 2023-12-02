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

public class NoteDataAccessObject implements CreateNoteDataAccessInterface,
        EditNoteDataAccessInterface, DeleteNoteDataAccessInterface, SearchNotesAccessInterface {

    private static final Map<Note, File> allNotes = new HashMap<>();
    private static int noteNumber = 0;
    private static Note currentNote;

    @Override
    public void create(Note note) throws IOException {

        // setting the ID of note most recently accessed
        noteNumber = note.getID();

        File noteFile = new File("notes/note"+noteNumber+".csv");

        // updating variables so we can more easily edit the note
        currentNote = note;
        allNotes.put(note, noteFile);

        this.updateNote(note.getID(), "", note.getName());
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
