package use_case.create_code_snippet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import use_case.create_code_snippet.CreateCodeSnippetInputData;

public class CreateCodeSnippetInputDataTest {

    @Test
    void testConstructorAndGetters() {
        // Create an instance of CreateCodeSnippetInputData
        CreateCodeSnippetInputData inputData = new CreateCodeSnippetInputData("Sample Code", "Existing Text",
                "Note Title", 123);

        // Verify that the values are correctly set by the constructor
        assertEquals("Sample Code", inputData.getCode());
        assertEquals("Existing Text", inputData.getNoteText());
        assertEquals("Note Title", inputData.getNoteTitle());
        assertEquals(123, inputData.getNoteID());
    }


}