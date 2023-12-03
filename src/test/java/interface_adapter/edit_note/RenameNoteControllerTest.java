package interface_adapter.edit_note;

import interface_adapter.edit_note.RenameNoteController;
import org.junit.jupiter.api.Test;
import use_case.rename_note.RenameNoteInputBoundary;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

class RenameNoteControllerTest {

    @Test
    void testExecute() throws IOException {
        // Arrange
        RenameNoteInputBoundary mockRenameInteractor = mock(RenameNoteInputBoundary.class);
        RenameNoteController renameNoteController = new RenameNoteController(mockRenameInteractor);

        // Mock data for testing
        int noteId = 456;
        String noteTitle = "New Note Title";
        String noteText = "Updated note text";

        // Act
        renameNoteController.execute(noteId, noteTitle, noteText);

        // Assert
        // Verify that the execute method of RenameNoteInputBoundary is called with the correct input data
        verify(mockRenameInteractor, times(1)).execute(argThat(data ->
                data.getNoteID() == noteId &&
                        data.getNoteTitle().equals(noteTitle) &&
                        data.getNoteText().equals(noteText)));
    }

    @Test
    void testConstructor() {
        // Arrange
        RenameNoteInputBoundary mockRenameInteractor = mock(RenameNoteInputBoundary.class);

        // Act
        RenameNoteController renameNoteController = new RenameNoteController(mockRenameInteractor);

        // Assert
        // Verify that the RenameNoteController is initialized with the provided RenameNoteInputBoundary
        assertSame(mockRenameInteractor, renameNoteController.renameInteractor);
    }
}
