package interface_adapter.search_notes;

import entity.Note.Note;

import java.util.ArrayList;
import java.util.List;

// Class declaration for SearchState
public class SearchState {
    // Instance variable for storing a list of notes
    private List<Note> notes;

    // Copy constructor for SearchState
    public SearchState(SearchState copy) {
        this.notes = new ArrayList<>(copy.notes);
    }

    // Default constructor for SearchState
    public SearchState() {
        this.notes = new ArrayList<>();
    }

    // Getter for the list of notes
    public List<Note> getNotes() {
        return this.notes;
    }

    // Setter for the list of notes
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
