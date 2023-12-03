package interface_adapter.back_menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.back_menu.BackMenuOutputBoundary;

public class BackMenuPresenter implements BackMenuOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final SearchViewModel searchViewModel;

    public BackMenuPresenter(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchViewModel = searchViewModel;
    }

    @Override
    public void prepareBackMenu() {
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
