package interface_adapter.edit_note;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

public class EditNotePresenter implements EditNoteOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final EditNoteViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    public EditNotePresenter(SearchViewModel searchViewModel, EditNoteViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(EditNoteOutputData note) {
        EditNoteState noteState = editViewModel.getState();
        this.editViewModel.setState(noteState);
        this.editViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(editViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
        System.out.println(viewManagerModel.getActiveView());
    }
}