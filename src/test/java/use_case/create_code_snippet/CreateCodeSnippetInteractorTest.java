package use_case.create_code_snippet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;

public class CreateCodeSnippetInteractorTest {

    @Test
    void testExecute() throws IOException {
        // Mock dependencies
        CreateCodeSnippetDataAccessInterface dataAccessObject = mock(CreateCodeSnippetDataAccessInterface.class);
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);

        // Create an instance of CreateCodeSnippetInputData
        CreateCodeSnippetInputData inputData = new CreateCodeSnippetInputData("Sample Code", "Existing Text",
                "Note Title", 123);

        // Create an instance of CreateCodeSnippetInteractor using the mock dependencies
        CreateCodeSnippetInteractor interactor = new CreateCodeSnippetInteractor(dataAccessObject, editNotePresenter);

        // Define the behavior of the mock data access object
        when(dataAccessObject.executeCode("Sample Code")).thenReturn(new StringBuilder("Code Execution Result"));

        // Call the execute method of the interactor
        interactor.execute(inputData);

        // Verify that the editNotePresenter's prepareNote method was called with the expected EditNoteOutputData
        verify(editNotePresenter).prepareNote(argThat(outputData ->
                outputData.getNoteID() == 123 &&
                        outputData.getNoteTitle().equals("Note Title") &&
                        outputData.getNoteText().contains("Ran code snippet:\n---\nSample Code\n---\nCode Execution Result")));
    }

    @Test
    void testCalculateNewText() {
        // Create an instance of CreateCodeSnippetInteractor
        CreateCodeSnippetInteractor interactor = new CreateCodeSnippetInteractor(null, null);

        // Test when existing text is empty
        assertEquals("\n\n", interactor.calculateNewText(""));

        // Test when existing text ends with a single newline character
        assertEquals("\n", interactor.calculateNewText("Existing Text\n"));

        // Test when existing text ends with two newline characters
        assertEquals("", interactor.calculateNewText("Existing Text\n\n"));

        // Test when existing text is not empty and doesn't end with newline characters
        assertEquals("\n\n", interactor.calculateNewText("Existing Text"));
    }

    // Additional test cases for specific scenarios can be added as needed
}
