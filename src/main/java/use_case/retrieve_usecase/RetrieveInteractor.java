package use_case.retrieve_usecase;

import use_case.edit_note.EditNoteOutputBoundary;
import use_case.search_notes.SearchNotesAccessInterface;
import use_case.search_notes.SearchOutputBoundary;

import java.io.IOException;
import java.util.ArrayList;

public class RetrieveInteractor implements  RetrieveInputBoundary {
    private final SearchOutputBoundary searchPresenter;
    private final SearchNotesAccessInterface searchNotesAccessInterface;
    public RetrieveInteractor(SearchOutputBoundary searchPresenter, SearchNotesAccessInterface searchNotesAccessInterface) {
        this.searchPresenter = searchPresenter;
        this.searchNotesAccessInterface = searchNotesAccessInterface;
    }

    @Override
    public void execute() throws IOException {
    }
}
