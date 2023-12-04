package app;

import static org.junit.jupiter.api.Assertions.*;

import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.search_notes.SearchNotesAccessInterface;
import view.SearchVIew;

public class SearchVIewUseCaseFactoryTest {

    @Test
    void testCreateEditNotePresenter() {
        // Mock dependencies
        CreateNoteViewModel createNoteViewModel = Mockito.mock(CreateNoteViewModel.class);
        EditNoteViewModel editNoteViewModel = Mockito.mock(EditNoteViewModel.class);
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);

        // Create an instance of EditNotePresenter using the helper method
        EditNotePresenter editNotePresenter = HomeViewUseCaseFactory.createEditNotePresenter(
                createNoteViewModel,
                editNoteViewModel,
                viewManagerModel
        );

        // Assert that the EditNotePresenter is not null
        assertNotNull(editNotePresenter);
    }

    @Test
    void testCreateCreateNoteController() {
        // Mock dependencies
        CreateNoteViewModel createNoteViewModel = Mockito.mock(CreateNoteViewModel.class);
        EditNoteViewModel editNoteViewModel = Mockito.mock(EditNoteViewModel.class);
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        SearchViewModel searchViewModel = Mockito.mock(SearchViewModel.class);
        CreateNoteDataAccessInterface noteDataAccessObject = Mockito.mock(CreateNoteDataAccessInterface.class);
        NoteFactory noteFactory = Mockito.mock(NoteFactory.class);

        // Create an instance of CreateNoteController using the helper method
        CreateNoteController createNoteController = HomeViewUseCaseFactory.createCreateNoteController(
                createNoteViewModel,
                editNoteViewModel,
                viewManagerModel,
                searchViewModel,
                noteDataAccessObject,
                noteFactory
        );

        // Assert that the CreateNoteController is not null
        assertNotNull(createNoteController);
    }

    @Test
    void testCreateSearchController() {
        // Mock dependencies
        CreateNoteViewModel createNoteViewModel = Mockito.mock(CreateNoteViewModel.class);
        EditNoteViewModel editNoteViewModel = Mockito.mock(EditNoteViewModel.class);
        SearchViewModel searchViewModel = Mockito.mock(SearchViewModel.class);
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        SearchNotesAccessInterface searchNotesAccessInterface = Mockito.mock(SearchNotesAccessInterface.class);

        // Create an instance of SearchController using the helper method
        SearchController searchController = HomeViewUseCaseFactory.createSearchController(
                createNoteViewModel,
                editNoteViewModel,
                searchViewModel,
                viewManagerModel,
                searchNotesAccessInterface
        );

        // Assert that the SearchController is not null
        assertNotNull(searchController);
    }

    @Test
    void testCreateHomeView() {
        // Mock dependencies
        CreateNoteViewModel createNoteViewModel = Mockito.mock(CreateNoteViewModel.class);
        EditNoteViewModel editNoteViewModel = Mockito.mock(EditNoteViewModel.class);
        SearchViewModel searchViewModel = Mockito.mock(SearchViewModel.class);
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);
        CreateNoteDataAccessInterface noteDataAccessObject = Mockito.mock(CreateNoteDataAccessInterface.class);
        SearchNotesAccessInterface searchNotesAccessInterface = Mockito.mock(SearchNotesAccessInterface.class);

        // Create an instance of HomeView using the factory method
        SearchVIew searchVIew = HomeViewUseCaseFactory.create(
                viewManagerModel,
                createNoteViewModel,
                editNoteViewModel,
                searchViewModel,
                noteDataAccessObject,
                searchNotesAccessInterface
        );

        // Assert that the HomeView is not null
        assertNotNull(searchVIew);
    }
}
