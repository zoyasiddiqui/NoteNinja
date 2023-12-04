package data_access;

import data_access.CreateCodeSnippetDataAccessObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateCodeSnippetDataAccessObjectTest {

    @Test
    void executeCode_SuccessfulExecution() {
        // Given
        CreateCodeSnippetDataAccessObject codeSnippetDAO = new CreateCodeSnippetDataAccessObject();
        String sampleCode = "print('Hello, World!')";

        // When
        StringBuilder output = codeSnippetDAO.executeCode(sampleCode);

        // Then
        assertNotNull(output);
        assertTrue(output.toString().contains("Hello, World!"));
    }


}
