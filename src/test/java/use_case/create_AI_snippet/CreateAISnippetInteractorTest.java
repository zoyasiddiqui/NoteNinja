package use_case.create_AI_snippet;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

public class CreateAISnippetInteractorTest {

    @Test
    void testExecute() throws IOException {
        // Mock dependencies
        CreateAISnippetDataAccessInterface dataAccessObject = mock(CreateAISnippetDataAccessInterface.class);
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);

        // Create an instance of CreateAISnippetInputData
        CreateAISnippetInputData inputData = new CreateAISnippetInputData("Sample Prompt", "Existing Text", "Note Title", 123);

        // Create an instance of CreateAISnippetInteractor using the mock dependencies
        CreateAISnippetInteractor interactor = new CreateAISnippetInteractor(dataAccessObject, editNotePresenter);

        // Define the behavior of the mock data access object
        when(dataAccessObject.getResponse("Sample Prompt")).thenReturn(new StringBuilder("AI Response"));

        // Call the execute method of the interactor
        interactor.execute(inputData);

        // Verify that the editNotePresenter's prepareNote method was called with the expected EditNoteOutputData
        verify(editNotePresenter).prepareNote(argThat(outputData ->
                outputData.getNoteID() == 123 &&
                        outputData.getNoteTitle().equals("Note Title") &&
                        outputData.getNoteText().contains("AI Response")));
    }

}
