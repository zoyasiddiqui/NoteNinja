package data_access;

import data_access.CreateAISnippetDataAccessObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateAISnippetDataAccessObjectTest {

    @Test
    void getResponse_SuccessfulRequest() {
        // Given
        CreateAISnippetDataAccessObject aiSnippetDAO = new CreateAISnippetDataAccessObject();
        String samplePrompt = "Translate the following English text to French: \"Hello, how are you?\"";

        // When
        StringBuilder response = aiSnippetDAO.getResponse(samplePrompt);

        // Then
        assertNotNull(response);
        assertFalse(response.toString().isEmpty());
    }


}
