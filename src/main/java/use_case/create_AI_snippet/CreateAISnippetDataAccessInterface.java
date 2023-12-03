// Package declaration indicating the location of the interface within the project structure
package use_case.create_AI_snippet;

// Definition of the CreateAISnippetDataAccessInterface interface
public interface CreateAISnippetDataAccessInterface {

    // Declaration of the getResponse method without implementation details
    // This method is expected to be implemented by classes that implement this interface
    // It takes a prompt as input and returns a StringBuilder representing the AI response
    StringBuilder getResponse(String prompt);
}
