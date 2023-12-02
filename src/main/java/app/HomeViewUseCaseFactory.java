// Package declaration
package app;

// Import statements for various classes and interfaces
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
import use_case.search_notes.SearchInteractor;
import use_case.search_notes.SearchNotesAccessInterface;
import view.HomeView;

// Class declaration
public class HomeViewUseCaseFactory {

    // Private constructor to prevent instantiation
    private HomeViewUseCaseFactory() {}

    // Factory method to create a HomeView
    public static HomeView create(ViewManagerModel viewManagerModel,
                                  CreateNoteViewModel createNoteViewModel,
                                  EditNoteViewModel editNoteViewModel,
                                  SearchViewModel searchViewModel,
                                  CreateNoteDataAccessInterface noteDataAccessObject,
                                  SearchNotesAccessInterface searchNotesAccessInterface) {

        // Create a NoteFactory for creating notes
        NoteFactory noteFactory = new CommonNoteFactory();

        // Create controllers for creating and searching notes
        CreateNoteController createNoteController = createCreateNoteController(createNoteViewModel,
                editNoteViewModel, viewManagerModel, searchViewModel, noteDataAccessObject, noteFactory);
        SearchController searchController = createSearchController(createNoteViewModel, editNoteViewModel,
                searchViewModel, viewManagerModel, searchNotesAccessInterface);

        // Return an instance of HomeView with the created controllers
        return new HomeView(createNoteViewModel, createNoteController, searchController);
    }

    // Helper method to create an EditNotePresenter
    private static EditNotePresenter createEditNotePresenter(CreateNoteViewModel createNoteViewModel,
                                                             EditNoteViewModel editNoteViewModel,
                                                             ViewManagerModel viewManagerModel) {
        return new EditNotePresenter(createNoteViewModel, editNoteViewModel, viewManagerModel);
    }

    // Helper method to create a CreateNoteController
    private static CreateNoteController createCreateNoteController(CreateNoteViewModel createNoteViewModel,
                                                                   EditNoteViewModel editNoteViewModel,
                                                                   ViewManagerModel viewManagerModel,
                                                                   SearchViewModel searchViewModel,
                                                                   CreateNoteDataAccessInterface noteDataAccessObject,
                                                                   NoteFactory noteFactory) {
        // To create a controller, we need an interactor.
        // To create an interactor, we need a presenter.

        // Create an EditNoteOutputBoundary using a helper method
        EditNoteOutputBoundary editNotePresenter = createEditNotePresenter(createNoteViewModel, editNoteViewModel,
                viewManagerModel);

        // Create a CreateNoteInteractor with the necessary dependencies
        CreateNoteInputBoundary createNoteInteractor = new CreateNoteInteractor(noteFactory, noteDataAccessObject, editNotePresenter);

        // Return a new CreateNoteController with the created interactor
        return new CreateNoteController(createNoteInteractor);
    }

    // Helper method to create a SearchController
    private static SearchController createSearchController(CreateNoteViewModel createNoteViewModel,
                                                           EditNoteViewModel editNoteViewModel,
                                                           SearchViewModel searchViewModel,
                                                           ViewManagerModel viewManagerModel,
                                                           SearchNotesAccessInterface searchNotesAccessInterface) {
        // Create an EditNoteOutputBoundary using a helper method
        EditNoteOutputBoundary editNotePresenter = createEditNotePresenter(createNoteViewModel,
                editNoteViewModel, viewManagerModel);

        // Create a SearchInteractor with the necessary dependencies
        SearchInteractor searchInteractor = new SearchInteractor(searchNotesAccessInterface, editNotePresenter);

        // Return a new SearchController with the created interactor
        return new SearchController(searchInteractor);
    }

}
