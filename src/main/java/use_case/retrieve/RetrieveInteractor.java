package use_case.retrieve;

import entity.Note.Note;
import use_case.search_notes.SearchNotesAccessInterface;
import use_case.search_notes.SearchOutputBoundary;

import java.util.ArrayList;

public class RetrieveInteractor implements RetrieveInputBoundary {
    private final SearchOutputBoundary searchNotePresenter;
    private final SearchNotesAccessInterface noteDataAccessObject;
    public RetrieveInteractor(SearchOutputBoundary searchNotePresenter, SearchNotesAccessInterface noteDataAccessObject) {
        this.searchNotePresenter = searchNotePresenter;
        this.noteDataAccessObject = noteDataAccessObject;
    }

    @Override
    public void execute() {
        ArrayList<Note> notes = noteDataAccessObject.getNotes();
        RetrieveOutputData retrieveOutputData = new RetrieveOutputData(notes);
        searchNotePresenter.loadOptions(retrieveOutputData);
    }
}
