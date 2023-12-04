package data_access;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCodeSnippetDataAccessObjectTest {
    @Test
    public void testParseCode() {
        // Create an instance of the data access object
        CreateCodeSnippetDataAccessObject dataAccessObject = new CreateCodeSnippetDataAccessObject();

        // Use reflection to access the private method
        try {
            Method parseCodeMethod = CreateCodeSnippetDataAccessObject.class.getDeclaredMethod("parseCode", String.class);
            parseCodeMethod.setAccessible(true);

            // Test the parseCode method with a sample code containing double quotes
            String codeWithQuotes = "print(\"Hello, World!\")";
            String parsedCode = (String) parseCodeMethod.invoke(dataAccessObject, codeWithQuotes);

            // Assert that the parsed code does not contain double quotes
            assertFalse(parsedCode.contains("\""));

            // You can add more specific assertions based on the expected behavior of parseCode
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            fail("Exception during test: " + e.getMessage());
        }
    }

    // You can add more test methods for other functionalities as needed
}
