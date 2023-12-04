package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import org.junit.jupiter.api.Test;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.search_notes.SearchNotesAccessInterface;
import view.SearchView;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

class HomeViewUseCaseFactoryTest {

    @Test
    void testCreateHomeView() throws IOException {
        // Mock dependencies
        ViewManagerModel viewManagerModel = mock(ViewManagerModel.class);
        EditNoteViewModel editNoteViewModel = mock(EditNoteViewModel.class);
        SearchViewModel searchViewModel = mock(SearchViewModel.class);

        // Use Mockito to create a mock that implements both interfaces
        SearchNotesAccessInterface searchNotesAccessInterface = mock(SearchNotesAccessInterface.class, withSettings().extraInterfaces(CreateNoteDataAccessInterface.class));

        // Call the method under test
        SearchView searchVIew = HomeViewUseCaseFactory.create(
                viewManagerModel,
                editNoteViewModel,
                searchViewModel,
                (CreateNoteDataAccessInterface) searchNotesAccessInterface
        );

        // Assert that the HomeView is not null
        assertNotNull(searchVIew);

    }
}
