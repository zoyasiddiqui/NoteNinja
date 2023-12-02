package interface_adapter.search_notes;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteViewModel;
import use_case.search_notes.SearchOutputBoundary;
import use_case.search_notes.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary{

    private final CreateNoteViewModel createNoteViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchPresenter(CreateNoteViewModel createNoteViewModel,
                           ViewManagerModel viewManagerModel) {
        this.createNoteViewModel = createNoteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SearchOutputData searchOutputData) {
        SearchState searchState = new SearchState();
        searchState.setNotes(searchOutputData.getNotes());

        this.createNoteViewModel.setState(searchState);
        this.createNoteViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(createNoteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errormessage) {

    }
}