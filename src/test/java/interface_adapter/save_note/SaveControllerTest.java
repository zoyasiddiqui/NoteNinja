package interface_adapter.save_note;

import org.junit.jupiter.api.Test;
import use_case.save_note.SaveNoteInputData;
import use_case.save_note.SaveNoteInteractor;

import java.io.IOException;

import static org.mockito.Mockito.*;

class SaveControllerTest {

    @Test
    void testExecute() throws IOException {
        // Arrange
        SaveNoteInteractor mockSaveNoteInteractor = mock(SaveNoteInteractor.class);
        SaveController saveController = new SaveController(mockSaveNoteInteractor);

        // Act
        saveController.execute("Test Title", "Test Text", 123);

        // Assert
        // Verify that the execute method of SaveNoteInteractor is called with the correct input data
        verify(mockSaveNoteInteractor, times(1)).execute(any(SaveNoteInputData.class));
    }

    @Test
    void testExecuteIOException() throws IOException {
        // Arrange
        SaveNoteInteractor mockSaveNoteInteractor = mock(SaveNoteInteractor.class);
        SaveController saveController = new SaveController(mockSaveNoteInteractor);

        // Set up the mock interactor to throw an IOException
        doThrow(new IOException("Test IOException")).when(mockSaveNoteInteractor).execute(any(SaveNoteInputData.class));

        // Act and Assert
        // Verify that an IOException is thrown when execute method is called
        try {
            saveController.execute("Test Title", "Test Text", 456);
        } catch (IOException e) {
            // Test passes if IOException is thrown
            return;
        }
        throw new AssertionError("Expected IOException but did not get one.");
    }
}
