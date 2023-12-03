package interface_adapter.search_notes;

import org.junit.jupiter.api.Test;
import use_case.search_notes.SearchInputBoundary;
import java.io.IOException;

import static org.mockito.Mockito.*;

class SearchControllerTest {

    @Test
    void testExecute() throws IOException {
        // Arrange
        SearchInputBoundary mockSearchNotesInteractor = mock(SearchInputBoundary.class);
        SearchController searchController = new SearchController(mockSearchNotesInteractor);

        // Act
        searchController.execute("Test Query");

        // Assert
        // Verify that the execute method of SearchInputBoundary is called with the correct input data
        verify(mockSearchNotesInteractor, times(1)).execute("Test Query");
    }

    @Test
    void testExecuteIOException() throws IOException {
        // Arrange
        SearchInputBoundary mockSearchNotesInteractor = mock(SearchInputBoundary.class);
        SearchController searchController = new SearchController(mockSearchNotesInteractor);

        // Set up the mock interactor to throw an IOException
        doThrow(new IOException("Test IOException")).when(mockSearchNotesInteractor).execute("Test Query");

        // Act and Assert
        // Verify that an IOException is thrown when execute method is called
        try {
            searchController.execute("Test Query");
        } catch (IOException e) {
            // Test passes if IOException is thrown
            return;
        }
        throw new AssertionError("Expected IOException but did not get one.");
    }
}
