package interface_adapter.search_notes;

import entity.Note.Note;
import java.util.List;

public class SearchState {
    private List<Note> notes;

    public SearchState(SearchState copy) {
        this.notes = copy.notes;
    }

    public SearchState() {}

    public List<Note> getNotes() {
        return this.notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}