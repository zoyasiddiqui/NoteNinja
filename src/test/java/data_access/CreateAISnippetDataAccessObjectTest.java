package data_access;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class CreateAISnippetDataAccessObjectTest {
    @Test
    public void testParsePrompt() {
        // Create an instance of the data access object
        CreateAISnippetDataAccessObject dataAccessObject = new CreateAISnippetDataAccessObject();

        // Use reflection to access the private method
        try {
            Method parsePromptMethod = CreateAISnippetDataAccessObject.class.getDeclaredMethod("parsePrompt", String.class);
            parsePromptMethod.setAccessible(true);

            // Test the parsePrompt method with a sample code containing double quotes
            String codeWithQuotes = "System.out.println(\"Hello, World!\");";
            String parsedCode = (String) parsePromptMethod.invoke(dataAccessObject, codeWithQuotes);

            // Assert that the parsed code does not contain double quotes
            assertFalse(parsedCode.contains("\""));

            // You can add more specific assertions based on the expected behavior of parsePrompt
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception during test: " + e.getMessage());
        }
    }

    // You can add more test methods for other functionalities as needed
}