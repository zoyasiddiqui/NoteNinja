// Package declaration indicating the location of the class within the project structure
package use_case.create_code_snippet;

// Definition of the CreateCodeSnippetOutputData class
public class CreateCodeSnippetOutputData {

    // Private instance variable to store output text
    private String text;

    // Constructor for initializing the CreateCodeSnippetOutputData object
    public CreateCodeSnippetOutputData(String text) {
        this.text = text;
    }

    // Getter method to retrieve the output text
    public String getText() {
        return this.text;
    }
}
