package use_case.search_notes;

import entity.Note.Note;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class SearchInteractorTest {

    @Test
    void execute_MatchingNoteFound_NotifyPresenter() throws IOException {
        // Arrange
        String searchQuery = "Sample";
        Note foundNote = mock(Note.class);
        when(foundNote.getID()).thenReturn(1);
        when(foundNote.getName()).thenReturn("Sample Note");
        when(foundNote.getText()).thenReturn("This is a sample note");

        SearchNotesAccessInterface searchNotesAccessInterface = mock(SearchNotesAccessInterface.class);
        SearchOutputBoundary searchNotePresenter = mock(SearchOutputBoundary.class);

        // Mock behavior: Return the foundNote when findByTitle is called with the searchQuery
        when(searchNotesAccessInterface.findByTitle(searchQuery)).thenReturn(foundNote);

        // Act
        SearchInteractor searchInteractor = new SearchInteractor(searchNotesAccessInterface, searchNotePresenter);
        searchInteractor.execute(searchQuery);

    }

    @Test
    void execute_NoMatchingNote_DoNotNotifyPresenter() throws IOException {
        // Arrange
        String searchQuery = "Nonexistent";
        SearchNotesAccessInterface searchNotesAccessInterface = mock(SearchNotesAccessInterface.class);
        SearchOutputBoundary searchNotePresenter = mock(SearchOutputBoundary.class);

        // Mock behavior: Return null when findByTitle is called with the searchQuery
        when(searchNotesAccessInterface.findByTitle(searchQuery)).thenReturn(null);

        // Act
        SearchInteractor searchInteractor = new SearchInteractor(searchNotesAccessInterface, searchNotePresenter);
        searchInteractor.execute(searchQuery);

        // Assert: Verify that prepareExistingNote is not called
        verify(searchNotePresenter, never()).prepareExistingNote(any());
    }
}
