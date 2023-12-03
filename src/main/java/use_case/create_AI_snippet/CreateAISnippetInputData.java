// Package declaration indicating the location of the class within the project structure
package use_case.create_AI_snippet;

// Definition of the CreateAISnippetInputData class
public class CreateAISnippetInputData {

    // Private instance variables to store input data
    private final String prompt;
    private final String noteText;
    private final String noteTitle;
    private final int noteID;

    // Constructor for initializing the CreateAISnippetInputData object
    public CreateAISnippetInputData(String prompt, String noteText, String noteTitle, int noteID) {
        this.prompt = prompt;
        this.noteText = noteText;
        this.noteTitle = noteTitle;
        this.noteID = noteID;
    }

    // Getter method to retrieve the prompt value
    public String getPrompt() {
        return prompt;
    }

    // Getter method to retrieve the noteText value
    public String getNoteText() {
        return noteText;
    }

    // Getter method to retrieve the noteTitle value
    public String getNoteTitle() {
        return noteTitle;
    }

    // Getter method to retrieve the noteID value
    public int getNoteID() {
        return noteID;
    }
}
