package use_case.retrieve_usecase;

import org.junit.jupiter.api.Test;
import use_case.retrieve_usecase.RetrieveInteractor;
import use_case.search_notes.SearchNotesAccessInterface;
import use_case.search_notes.SearchOutputBoundary;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RetrieveInteractorTest {

    @Test
    void testExecute() throws IOException {
        // Mock dependencies
        SearchOutputBoundary searchPresenter = mock(SearchOutputBoundary.class);
        SearchNotesAccessInterface searchNotesAccessInterface = mock(SearchNotesAccessInterface.class);

        // Create an instance of RetrieveInteractor with the mocked dependencies
        RetrieveInteractor retrieveInteractor = new RetrieveInteractor(searchPresenter, searchNotesAccessInterface);

        // Call the method under test
        retrieveInteractor.execute();
    }
}
