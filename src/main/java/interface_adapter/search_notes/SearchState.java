package interface_adapter.search_notes;

import entity.Note.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Class declaration for SearchState
public class SearchState {
    // Instance variable for storing a list of notes
    private HashMap<Integer, String> notes;

    // Copy constructor for SearchState
    public SearchState(SearchState copy) {
        this.notes = copy.notes;
    }

    // Default constructor for SearchState
    public SearchState() {
        this.notes = new HashMap<>();
    }

    // Getter for the list of notes
    public HashMap<Integer, String> getNotes() {
        return this.notes;
    }

    // Setter for the list of notes
    public void setNotes(HashMap<Integer, String> notes) {
        this.notes = notes;
    }
}
