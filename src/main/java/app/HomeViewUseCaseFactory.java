// Package declaration
package app;

// Import statements for various classes and interfaces
import entity.Note.CommonNoteFactory;
import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.search_notes.SearchViewModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchPresenter;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.create_note.CreateNoteInputBoundary;
import use_case.create_note.CreateNoteInteractor;
import use_case.search_notes.SearchInteractor;
import use_case.search_notes.SearchNotesAccessInterface;
import use_case.search_notes.SearchOutputBoundary;
import view.SearchView;

import java.io.IOException;

// Class declaration
public class HomeViewUseCaseFactory {

    // Private constructor to prevent instantiation
    private HomeViewUseCaseFactory() {}

    // Factory method to create a HomeView
    public static SearchView create(ViewManagerModel viewManagerModel,
                                    EditNoteViewModel editNoteViewModel,
                                    SearchViewModel searchViewModel,
                                    CreateNoteDataAccessInterface noteDataAccessObject) throws IOException {

        // Create a NoteFactory for creating notes
        NoteFactory noteFactory = new CommonNoteFactory();

        SearchOutputBoundary searchNotePresenter = createSearchNotePresenter(
                searchViewModel,
                editNoteViewModel,
                viewManagerModel);

        // Create controllers for creating and searching notes
        CreateNoteController createNoteController = createCreateNoteController(searchNotePresenter, noteDataAccessObject, noteFactory);
        SearchController searchController = createSearchController(searchNotePresenter, (SearchNotesAccessInterface) noteDataAccessObject);

        // Return an instance of HomeView with the created controllers
        return new SearchView(searchViewModel, createNoteController, searchController);
    }

    private static SearchOutputBoundary createSearchNotePresenter(SearchViewModel searchViewModel,
                                                                  EditNoteViewModel editNoteViewModel,
                                                                  ViewManagerModel viewManagerModel) {
        return new SearchPresenter(searchViewModel, editNoteViewModel, viewManagerModel);

    }

    // Helper method to create a CreateNoteController
    private static CreateNoteController createCreateNoteController(SearchOutputBoundary searchNotePresenter,
                                                                   CreateNoteDataAccessInterface noteDataAccessObject,
                                                                   NoteFactory noteFactory) {
        // To create a controller, we need an interactor.
        // To create an interactor, we need a presenter.
        // Create a CreateNoteInteractor with the necessary dependencies
        CreateNoteInputBoundary createNoteInteractor = new CreateNoteInteractor(noteFactory, noteDataAccessObject, searchNotePresenter);

        // Return a new CreateNoteController with the created interactor
        return new CreateNoteController(createNoteInteractor);
    }

    // Helper method to create a SearchController
    private static SearchController createSearchController(SearchOutputBoundary searchNotePresenter,
                                                           SearchNotesAccessInterface searchNotesAccessInterface) {
        // Create an SearchOutputBoundary using a helper method

        // Create a SearchInteractor with the necessary dependencies
        SearchInteractor searchInteractor = new SearchInteractor(searchNotesAccessInterface, searchNotePresenter);

        // Return a new SearchController with the created interactor
        return new SearchController(searchInteractor);
    }

}
