package app;

import data_access.EditNoteDataAccessObject;
import data_access.ManageNotesDataAccessObject;
import entity.Note.CommonNoteFactory;
import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.create_note.CreateNotePresenter;
import interface_adapter.edit_note.EditPresenter;
import interface_adapter.edit_note.EditViewModel;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchPresenter;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.create_note.CreateNoteInputBoundary;
import use_case.create_note.CreateNoteInteractor;
import use_case.create_note.CreateNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.search_notes.SearchInputBoundary;
import use_case.search_notes.SearchInteractor;
import use_case.search_notes.SearchNotesAccessInterface;
import use_case.search_notes.SearchOutputBoundary;
import view.SearchNotesView;

public class SearchNotesUseCaseFactory {

    private SearchNotesUseCaseFactory() {}

    public static SearchNotesView create(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel, EditViewModel editViewModel) {

        SearchController searchController = createSearchController();
        CreateNoteController createNoteController = createCreateNoteController(searchViewModel, editViewModel, viewManagerModel);

        return new SearchNotesView(searchViewModel, searchController, editViewModel, createNoteController);
    }

    private static SearchController createSearchController() {
        SearchNotesAccessInterface dataAccessObject = new ManageNotesDataAccessObject();

        //need to figure out why we even have this boundary
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter();

        SearchInputBoundary searchNoteInteractor = new SearchInteractor(dataAccessObject);
        return new SearchController(searchNoteInteractor);
    }

    private static CreateNoteController createCreateNoteController(SearchViewModel searchViewModel, EditViewModel editViewModel, ViewManagerModel viewManagerModel) {
        CreateNoteDataAccessInterface dataAccessObject = new EditNoteDataAccessObject();

        EditNoteOutputBoundary editNotePresenter = new EditPresenter(searchViewModel, editViewModel, viewManagerModel);

        NoteFactory noteFactory = new CommonNoteFactory();

        CreateNoteInputBoundary createNoteInteractor = new CreateNoteInteractor(noteFactory, dataAccessObject, editNotePresenter);
        return new CreateNoteController(createNoteInteractor);
    }

}
