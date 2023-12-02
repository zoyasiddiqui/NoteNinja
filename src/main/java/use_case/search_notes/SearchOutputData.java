package use_case.search_notes;

import entity.Note.Note;
import java.util.List;

public class SearchOutputData{

    List<Note> notes;

    public SearchOutputData(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes() {
        return this.notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}