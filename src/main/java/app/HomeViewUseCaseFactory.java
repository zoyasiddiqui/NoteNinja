package app;

import data_access.NoteDataAccessObject;
import entity.Note.CommonNoteFactory;
import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.create_note.CreateNoteInputBoundary;
import use_case.create_note.CreateNoteInteractor;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import use_case.search_notes.SearchInteractor;
import use_case.search_notes.SearchNotesAccessInterface;
import view.HomeView;

import javax.swing.text.View;

public class HomeViewUseCaseFactory {

    private HomeViewUseCaseFactory() {}

    public static HomeView create(ViewManagerModel viewManagerModel,
                                  CreateNoteViewModel createNoteViewModel,
                                  EditNoteViewModel editNoteViewModel,
                                  SearchViewModel searchViewModel,
                                  CreateNoteDataAccessInterface noteDataAccessObject,
                                  SearchNotesAccessInterface searchNotesAccessInterface) {

        NoteFactory noteFactory = new CommonNoteFactory();
        CreateNoteController createNoteController = createCreateNoteController(createNoteViewModel,
                editNoteViewModel, viewManagerModel, searchViewModel, noteDataAccessObject, noteFactory);
        SearchController searchController = createSearchController(createNoteViewModel, editNoteViewModel,
                searchViewModel, viewManagerModel, searchNotesAccessInterface);

        return new HomeView(createNoteViewModel, createNoteController, searchController);
    }

    private static EditNotePresenter createEditNotePresenter(CreateNoteViewModel createNoteViewModel,
                                                                  EditNoteViewModel editNoteViewModel,
                                                                  ViewManagerModel viewManagerModel) {
        return new EditNotePresenter(createNoteViewModel, editNoteViewModel, viewManagerModel);
    }

    private static CreateNoteController createCreateNoteController(CreateNoteViewModel createNoteViewModel,
                                                                   EditNoteViewModel editNoteViewModel,
                                                                   ViewManagerModel viewManagerModel,
                                                                   SearchViewModel searchViewModel,
                                                                   CreateNoteDataAccessInterface noteDataAccessObject,
                                                                   NoteFactory noteFactory) {
        //to create a controller we need an interactor.
        //to create an interactor we need a presenter

        EditNoteOutputBoundary editNotePresenter = createEditNotePresenter(createNoteViewModel, editNoteViewModel,
                viewManagerModel);
        CreateNoteInputBoundary createNoteInteractor = new CreateNoteInteractor(noteFactory, noteDataAccessObject, editNotePresenter);
        return new CreateNoteController(createNoteInteractor);

    }

    private static SearchController createSearchController(CreateNoteViewModel createNoteViewModel,
                                                           EditNoteViewModel editNoteViewModel,
                                                           SearchViewModel searchViewModel,
                                                           ViewManagerModel viewManagerModel,
                                                           SearchNotesAccessInterface searchNotesAccessInterface) {
        EditNoteOutputBoundary editNotePresenter = createEditNotePresenter(createNoteViewModel,
                editNoteViewModel, viewManagerModel);
        SearchInteractor searchInteractor = new SearchInteractor(searchNotesAccessInterface, editNotePresenter);
        return new SearchController(searchInteractor);
    }

}
