package interface_adapter.delete_note;

import org.junit.jupiter.api.Test;
import use_case.delete_note.DeleteNoteInputBoundary;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

class DeleteNoteControllerTest {

    @Test
    void testExecute() throws IOException {
        // Arrange
        DeleteNoteInputBoundary mockDeleteNoteInteractor = mock(DeleteNoteInputBoundary.class);
        DeleteNoteController deleteNoteController = new DeleteNoteController(mockDeleteNoteInteractor);

        // Mock data for testing
        int noteId = 123;

        // Act
        deleteNoteController.execute(noteId);

        // Assert
        // Verify that the execute method of DeleteNoteInteractor is called with the correct noteId
        verify(mockDeleteNoteInteractor, times(1)).execute(eq(noteId));
    }

    @Test
    void testConstructor() {
        // Arrange
        DeleteNoteInputBoundary mockDeleteNoteInteractor = mock(DeleteNoteInputBoundary.class);

        // Act
        DeleteNoteController deleteNoteController = new DeleteNoteController(mockDeleteNoteInteractor);

        // Assert
        // Verify that the DeleteNoteController is initialized with the provided DeleteNoteInteractor
        assertSame(mockDeleteNoteInteractor, deleteNoteController.deleteNoteInteractor);
    }
}
