package data_access;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;


public class NoteDataAccessObjectTest {
    @Test
    public void testParseCode() {
        // Create an instance of the data access object
        CreateCodeSnippetDataAccessObject dataAccessObject = new CreateCodeSnippetDataAccessObject();

        // Use reflection to access the private method
        try {
            String codeWithQuotes = "print(\"Hello, World!\")";

            // Test the parseCode method using reflection
            String parsedCode = invokePrivateMethod(dataAccessObject, "parseCode", codeWithQuotes);

            // Assert that the parsed code does not contain double quotes
            assertFalse(parsedCode.contains("\""));

            // You can add more specific assertions based on the expected behavior of parseCode
        } catch (Exception e) {
            fail("Exception during test: " + e.getMessage());
        }
    }

    private String invokePrivateMethod(Object object, String methodName, Object... parameters) throws Exception {
        Class<?>[] parameterTypes = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            parameterTypes[i] = parameters[i].getClass();
        }

        Method method = object.getClass().getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);

        return (String) method.invoke(object, parameters);
    }

    // You can add more test methods for other functionalities as needed
}
