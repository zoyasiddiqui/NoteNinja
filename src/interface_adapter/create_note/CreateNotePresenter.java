package interface_adapter.create_note;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.NoteEditViewModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_note.CreateNoteOutputBoundary;
import use_case.create_note.CreateNoteOutputData;

public class CreateNotePresenter implements CreateNoteOutputBoundary {

    private final SearchViewModel searchViewModel;
    private final NoteEditViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateNotePresenter(SearchViewModel searchViewModel, NoteEditViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CreateNoteOutputData response) {
        viewManagerModel.setActiveView(editViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        searchViewModel.firePropertyChanged();
    }
}