package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;
import interface_adapter.switch_to_search.SwitchToSearchController;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.search_notes.SearchInteractor;
import use_case.search_notes.SearchNotesAccessInterface;
import use_case.switch_to_search.SwitchToSearchInteractor;
import view.SearchNotesView;

import javax.swing.text.View;

public class SearchNotesUseCase {

    SearchNotesUseCase() {}

    public static SearchNotesView create(ViewManagerModel viewManagerModel,
                                         CreateNoteViewModel createNoteViewModel,
                                         EditNoteViewModel editNoteViewModel,
                                         SearchViewModel searchViewModel,
                                         SearchNotesAccessInterface searchNotesAccessInterface) {

        SwitchToSearchController switchToSearchController = createSwitchController(createNoteViewModel,
                editNoteViewModel, searchViewModel, viewManagerModel);
        SearchController searchController = createSearchController(createNoteViewModel, editNoteViewModel,
                searchViewModel, viewManagerModel, searchNotesAccessInterface);
        return new SearchNotesView(searchViewModel, searchController, switchToSearchController);

    }

    private static EditNotePresenter createEditNotePresenter(CreateNoteViewModel createNoteViewModel,
                                                             EditNoteViewModel editNoteViewModel,
                                                             SearchViewModel searchViewModel,
                                                             ViewManagerModel viewManagerModel) {
        return new EditNotePresenter(createNoteViewModel, editNoteViewModel, searchViewModel, viewManagerModel);
    }

    private static SwitchToSearchController createSwitchController(CreateNoteViewModel createNoteViewModel,
                                            EditNoteViewModel editNoteViewModel,
                                            SearchViewModel searchViewModel,
                                            ViewManagerModel viewManagerModel) {

        EditNoteOutputBoundary editNotePresenter = createEditNotePresenter(createNoteViewModel,
                editNoteViewModel, searchViewModel, viewManagerModel);
        SwitchToSearchInteractor switchToSearchInteractor = new SwitchToSearchInteractor(editNotePresenter);
        return new SwitchToSearchController(switchToSearchInteractor);
    }

    private static SearchController createSearchController(CreateNoteViewModel createNoteViewModel,
                                                           EditNoteViewModel editNoteViewModel,
                                                           SearchViewModel searchViewModel,
                                                           ViewManagerModel viewManagerModel,
                                                           SearchNotesAccessInterface searchNotesAccessInterface) {
        EditNoteOutputBoundary editNotePresenter = createEditNotePresenter(createNoteViewModel,
                editNoteViewModel, searchViewModel, viewManagerModel);
        SearchInteractor searchInteractor = new SearchInteractor(searchNotesAccessInterface, editNotePresenter);
        return new SearchController(searchInteractor);
    }

}
