package use_case.retrieve;

import entity.Note.Note;
import use_case.search_notes.SearchNotesAccessInterface;
import use_case.search_notes.SearchOutputBoundary;

import java.util.ArrayList;
import java.util.HashMap;

public class RetrieveInteractor implements RetrieveInputBoundary {
    private final SearchOutputBoundary searchNotePresenter;
    private final SearchNotesAccessInterface noteDataAccessObject;
    public RetrieveInteractor(SearchOutputBoundary searchNotePresenter, SearchNotesAccessInterface noteDataAccessObject) {
        this.searchNotePresenter = searchNotePresenter;
        this.noteDataAccessObject = noteDataAccessObject;
    }

    @Override
    public void execute() {
        ArrayList<Note> noteArray = noteDataAccessObject.getNotes();
        HashMap<Integer, String> notes = new HashMap<>(); // hashmap <noteID, noteTitle>
        for (Note note: noteArray) {
            notes.put(note.getID(), note.getName());
        }
        RetrieveOutputData retrieveOutputData = new RetrieveOutputData(notes);
        searchNotePresenter.loadOptions(retrieveOutputData);
    }
}
