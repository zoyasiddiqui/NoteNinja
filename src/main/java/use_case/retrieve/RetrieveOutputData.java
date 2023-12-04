package use_case.retrieve;

import entity.Note.Note;

import java.util.ArrayList;

public class RetrieveOutputData {
    private final ArrayList<Note> notes;
    RetrieveOutputData (ArrayList<Note> notes) {
        this.notes = notes;
    }
    public ArrayList<Note> getNotes() {
        return notes;
    }
}

