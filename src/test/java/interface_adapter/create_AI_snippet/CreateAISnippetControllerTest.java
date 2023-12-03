package interface_adapter.create_AI_snippet;

import org.junit.jupiter.api.Test;
import use_case.create_AI_snippet.CreateAISnippetInputBoundary;

import java.io.IOException;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

class CreateAISnippetControllerTest {

    @Test
    void testExecute() throws IOException, IOException {
        // Arrange
        CreateAISnippetInputBoundary mockCreateAISnippetInteractor = mock(CreateAISnippetInputBoundary.class);
        CreateAISnippetController createAISnippetController = new CreateAISnippetController(mockCreateAISnippetInteractor);

        // Mock data for testing
        String prompt = "Test prompt";
        String noteText = "Test note text";
        String noteTitle = "Test note title";
        int noteID = 123;

        // Act
        createAISnippetController.execute(prompt, noteText, noteTitle, noteID);

        // Assert
        // Verify that the execute method of CreateAISnippetInteractor is called with the correct input data
        verify(mockCreateAISnippetInteractor, times(1)).execute(argThat(data ->
                data.getPrompt().equals(prompt) &&
                        data.getNoteText().equals(noteText) &&
                        data.getNoteTitle().equals(noteTitle) &&
                        data.getNoteID() == noteID));
    }

    @Test
    void testConstructor() {
        // Arrange
        CreateAISnippetInputBoundary mockCreateAISnippetInteractor = mock(CreateAISnippetInputBoundary.class);

        // Act
        CreateAISnippetController createAISnippetController = new CreateAISnippetController(mockCreateAISnippetInteractor);

        // Assert
        // Verify that the CreateAISnippetController is initialized with the provided CreateAISnippetInteractor
        assertSame(mockCreateAISnippetInteractor, createAISnippetController.createAISnippetInteractor);
    }
}
