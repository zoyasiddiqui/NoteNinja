// Package declaration indicating the location of the class within the project structure
package use_case.create_AI_snippet;

// Definition of the CreateAISnippetOutputData class
public class CreateAISnippetOutputData {

    // Private instance variable to store output text
    private String text;

    // Constructor for initializing the CreateAISnippetOutputData object
    public CreateAISnippetOutputData(String text) {
        this.text = text;
    }

    // Getter method to retrieve the output text
    public String getText() {
        return this.text;
    }
}
