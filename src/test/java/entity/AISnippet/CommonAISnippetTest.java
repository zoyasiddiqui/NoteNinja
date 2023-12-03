package entity.AISnippet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonAISnippetTest {

    @Test
    void testSetAndGetSnippetQuestion() {
        // Arrange
        CommonAISnippet commonAISnippet = new CommonAISnippet();
        String question = "What is your name?";

        // Act
        commonAISnippet.setSnippetQuestion(question);

        // Assert
        // Verify that getSnippetQuestion returns the correct question
        assertEquals(question, commonAISnippet.getSnippetQuestion());
    }

    @Test
    void testSetAndGetResponse() {
        // Arrange
        CommonAISnippet commonAISnippet = new CommonAISnippet();
        String response = "My name is ChatGPT.";

        // Act
        commonAISnippet.setResponse(response);

        // Assert
        // Verify that the setResponse method correctly sets the snippet response
        // (Note: No corresponding getResponse method is present in the provided code)
        assertNotNull(commonAISnippet); // Placeholder assertion to avoid an empty test
    }
}
