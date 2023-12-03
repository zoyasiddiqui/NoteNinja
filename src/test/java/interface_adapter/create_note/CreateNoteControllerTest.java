package interface_adapter.create_note;

import org.junit.jupiter.api.Test;
import use_case.create_note.CreateNoteInputBoundary;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

class CreateNoteControllerTest {

    @Test
    void testExecute() throws IOException, IOException {
        // Arrange
        CreateNoteInputBoundary mockCreateNoteInteractor = mock(CreateNoteInputBoundary.class);
        CreateNoteController createNoteController = new CreateNoteController(mockCreateNoteInteractor);

        // Mock data for testing
        String noteTitle = "Test note title";
        String noteText = "Test note text";

        // Act
        createNoteController.execute(noteTitle, noteText);

        // Assert
        // Verify that the execute method of CreateNoteInteractor is called with the correct input data
        verify(mockCreateNoteInteractor, times(1)).execute(argThat(data ->
                data.getNoteTitle().equals(noteTitle) &&
                        data.getNoteText().equals(noteText)));
    }

    @Test
    void testConstructor() {
        // Arrange
        CreateNoteInputBoundary mockCreateNoteInteractor = mock(CreateNoteInputBoundary.class);

        // Act
        CreateNoteController createNoteController = new CreateNoteController(mockCreateNoteInteractor);

        // Assert
        // Verify that the CreateNoteController is initialized with the provided CreateNoteInteractor
        assertSame(mockCreateNoteInteractor, createNoteController.createNoteInteractor);
    }
}
