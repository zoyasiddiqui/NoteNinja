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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NoteDataAccessObject implements CreateNoteDataAccessInterface,
        EditNoteDataAccessInterface, DeleteNoteDataAccessInterface, SearchNotesAccessInterface {

    private static final Map<Note, File> allNotes = new HashMap<>();

    //TODO: figure out if the below 2 should be static
    private int noteNumber = 0;
    private Note currentNote;

    @Override
    public void create(Note note) throws IOException {

        // setting the ID of note most recently accessed
        this.noteNumber = note.getID();

        File noteFile = new File("notes/note"+noteNumber+".csv");

        // updating variables so we can more easily edit the note
        this.currentNote = note;
        this.allNotes.put(note, noteFile);

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
                this.currentNote = n;
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
        }
    }

    @Override
    public String getCurrentText() {
        return this.currentNote.getText();
    }

    @Override
    public void setCurrentText(String text) {
        this.currentNote.setText(text);
    }

    @Override
    public void findByTitle(String noteTitle) {
        // TODO: implement this if we choose to implement the search notes use case
    }
}
