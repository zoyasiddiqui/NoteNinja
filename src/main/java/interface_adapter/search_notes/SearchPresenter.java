package interface_adapter.search_notes;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteState;
import interface_adapter.edit_note.EditNoteViewModel;
import use_case.edit_note.EditNoteOutputData;
import use_case.retrieve.RetrieveOutputData;
import use_case.search_notes.SearchOutputBoundary;
import use_case.search_notes.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary{

    private final SearchViewModel searchViewModel;
    private final EditNoteViewModel editNoteViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchPresenter(SearchViewModel searchViewModel,
                           EditNoteViewModel editNoteViewModel,
                           ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.editNoteViewModel = editNoteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareNewNote(EditNoteOutputData editNoteOutputData) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteTitle(editNoteOutputData.getNoteTitle());
        noteState.setNoteText(editNoteOutputData.getNoteText());
        noteState.setNoteID(editNoteOutputData.getNoteID()); // be careful that createNoteInteractor is the only one that affects this
        this.editNoteViewModel.setState(noteState);
        this.editNoteViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(editNoteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errormessage) {

    }

    @Override
    public void prepareExistingNote(EditNoteOutputData editNoteOutputData) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteText(editNoteOutputData.getNoteText());
        noteState.setNoteTitle(editNoteOutputData.getNoteTitle());
        noteState.setNoteID(editNoteOutputData.getNoteID());
        this.editNoteViewModel.setState(noteState);
        this.editNoteViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(editNoteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void loadOptions(RetrieveOutputData retrieveOutputData) {
        SearchState searchState = searchViewModel.getState();
        searchState.setNotes(retrieveOutputData.getNotes());
    }
}