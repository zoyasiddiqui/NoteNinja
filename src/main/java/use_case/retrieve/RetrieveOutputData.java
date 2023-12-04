package use_case.retrieve;

import entity.Note.Note;

import java.util.ArrayList;
import java.util.HashMap;

public class RetrieveOutputData {
    private final HashMap<Integer, String> notes;
    RetrieveOutputData (HashMap<Integer, String> notes) {
        this.notes = notes;
    }
    public HashMap<Integer, String> getNotes() {
        return notes;
    }
}

