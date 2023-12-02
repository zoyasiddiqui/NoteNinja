package app;

import data_access.NoteDataAccessObject;
import entity.Note.CommonNoteFactory;
import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import interface_adapter.switch_to_search.SwitchToSearchController;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.create_note.CreateNoteInputBoundary;
import use_case.create_note.CreateNoteInteractor;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import use_case.switch_to_search.SwitchToSearchInteractor;
import view.HomeView;

import javax.swing.text.View;

public class HomeViewUseCaseFactory {

    private HomeViewUseCaseFactory() {}

    public static HomeView create(ViewManagerModel viewManagerModel,
                                  CreateNoteViewModel createNoteViewModel,
                                  EditNoteViewModel editNoteViewModel,
                                  SearchViewModel searchViewModel,
                                  CreateNoteDataAccessInterface noteDataAccessObject) {

        NoteFactory noteFactory = new CommonNoteFactory();
        EditNotePresenter editNotePresenter = createEditNotePresenter(createNoteViewModel,
                editNoteViewModel, searchViewModel, viewManagerModel);
        CreateNoteController createNoteController = createCreateNoteController(createNoteViewModel,
                editNoteViewModel, viewManagerModel, searchViewModel, noteDataAccessObject, noteFactory);
        SwitchToSearchController searchController = createSearchController(editNotePresenter);

        return new HomeView(createNoteViewModel, createNoteController, searchController);
    }

    private static EditNotePresenter createEditNotePresenter(CreateNoteViewModel createNoteViewModel,
                                                                  EditNoteViewModel editNoteViewModel,
                                                                  SearchViewModel searchViewModel,
                                                                  ViewManagerModel viewManagerModel) {
        return new EditNotePresenter(createNoteViewModel, editNoteViewModel, searchViewModel, viewManagerModel);
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
                searchViewModel, viewManagerModel);
        CreateNoteInputBoundary createNoteInteractor = new CreateNoteInteractor(noteFactory, noteDataAccessObject, editNotePresenter);
        return new CreateNoteController(createNoteInteractor);

    }

    private static SwitchToSearchController createSearchController(EditNoteOutputBoundary editNotePresenter) {
        SwitchToSearchInteractor searchInteractor = new SwitchToSearchInteractor(editNotePresenter);
        return new SwitchToSearchController(searchInteractor);
    }

}
