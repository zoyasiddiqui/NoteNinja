package interface_adapter.create_code_snippet;

import org.junit.jupiter.api.Test;
import use_case.create_code_snippet.CreateCodeSnippetInputBoundary;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

class CreateCodeSnippetControllerTest {

    @Test
    void testExecute() throws IOException {
        // Arrange
        CreateCodeSnippetInputBoundary mockCreateCodeSnippetInteractor = mock(CreateCodeSnippetInputBoundary.class);
        CreateCodeSnippetController createCodeSnippetController = new CreateCodeSnippetController(mockCreateCodeSnippetInteractor);

        // Mock data for testing
        String code = "Test code snippet";
        String noteText = "Test note text";
        String noteTitle = "Test note title";
        int noteID = 456;

        // Act
        createCodeSnippetController.execute(code, noteText, noteTitle, noteID);

        // Assert
        // Verify that the execute method of CreateCodeSnippetInteractor is called with the correct input data
        verify(mockCreateCodeSnippetInteractor, times(1)).execute(argThat(data ->
                data.getCode().equals(code) &&
                        data.getNoteText().equals(noteText) &&
                        data.getNoteTitle().equals(noteTitle) &&
                        data.getNoteID() == noteID));
    }

    @Test
    void testConstructor() {
        // Arrange
        CreateCodeSnippetInputBoundary mockCreateCodeSnippetInteractor = mock(CreateCodeSnippetInputBoundary.class);

        // Act
        CreateCodeSnippetController createCodeSnippetController = new CreateCodeSnippetController(mockCreateCodeSnippetInteractor);

        // Assert
        // Verify that the CreateCodeSnippetController is initialized with the provided CreateCodeSnippetInteractor
        assertSame(mockCreateCodeSnippetInteractor, createCodeSnippetController.createCodeSnippetInteractor);
    }
}
