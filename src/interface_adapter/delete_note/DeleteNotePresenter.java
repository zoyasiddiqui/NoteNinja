package interface_adapter.delete_note;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.delete_note.DeleteNoteOutputBoundary;
import use_case.delete_note.DeleteNoteOutputData;

public class DeleteNotePresenter implements DeleteNoteOutputBoundary {

    private final SearchViewModel searchViewModel;
    private final EditNoteViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    public DeleteNotePresenter(SearchViewModel searchViewModel, EditNoteViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteNoteOutputData response) {
        viewManagerModel.setActiveView(editViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        searchViewModel.firePropertyChanged();
    }
}
