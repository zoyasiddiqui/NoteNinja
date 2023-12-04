package use_case.retrieve;

import use_case.search_notes.SearchNotesAccessInterface;
import use_case.search_notes.SearchOutputBoundary;

public class RetrieveInteractor implements RetrieveInputBoundary {
    private final SearchOutputBoundary searchNotePresenter;
    private final SearchNotesAccessInterface noteDataAccessObject;
    public RetrieveInteractor(SearchOutputBoundary searchNotePresenter, SearchNotesAccessInterface noteDataAccessObject) {
        this.searchNotePresenter = searchNotePresenter;
        this.noteDataAccessObject = noteDataAccessObject;
    }

    @Override
    public void execute() {

    }
}
