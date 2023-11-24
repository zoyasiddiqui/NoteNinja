package interface_adapter.save_note;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.save_note.SaveNoteOutputBoundary;

public class SavePresenter implements SaveNoteOutputBoundary{

    private final SearchViewModel searchViewModel;
    private final EditNoteViewModel editNoteViewModel;
    private final ViewManagerModel viewManagerModel;

    public SavePresenter(SearchViewModel searchViewModel, EditNoteViewModel editNoteViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.editNoteViewModel = editNoteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errormessage) {

    }
}

// i think we can totally delete this presenter, no need for it