package use_case.create_AI_snippet;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CreateAISnippetInputDataTest {

    @Test
    void testConstructorAndGetters() {
        // Create test values
        String prompt = "Test Prompt";
        String noteText = "Test Note Text";
        String noteTitle = "Test Note Title";
        int noteID = 123;

        // Create an instance of CreateAISnippetInputData
        CreateAISnippetInputData inputData = new CreateAISnippetInputData(prompt, noteText, noteTitle, noteID);

        // Assert that the constructor sets values correctly
        assertEquals(prompt, inputData.getPrompt());
        assertEquals(noteText, inputData.getNoteText());
        assertEquals(noteTitle, inputData.getNoteTitle());
        assertEquals(noteID, inputData.getNoteID());
    }

    @Test
    void testImmutable() {
        // Create test values
        String prompt = "Test Prompt";
        String noteText = "Test Note Text";
        String noteTitle = "Test Note Title";
        int noteID = 123;

        // Create an instance of CreateAISnippetInputData
        CreateAISnippetInputData inputData = new CreateAISnippetInputData(prompt, noteText, noteTitle, noteID);

        // Modify the original values
        prompt = "Modified Prompt";
        noteText = "Modified Note Text";
        noteTitle = "Modified Note Title";
        noteID = 456;

        // Assert that the CreateAISnippetInputData instance remains unchanged
        assertEquals("Test Prompt", inputData.getPrompt());
        assertEquals("Test Note Text", inputData.getNoteText());
        assertEquals("Test Note Title", inputData.getNoteTitle());
        assertEquals(123, inputData.getNoteID());
    }
}
