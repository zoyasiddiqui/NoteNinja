// Package declaration
package interface_adapter.create_code_snippet;

// Import statements for various classes and interfaces
import interface_adapter.edit_note.EditNoteState;
import use_case.create_code_snippet.CreateCodeSnippetInputBoundary;
import use_case.create_code_snippet.CreateCodeSnippetInputData;

import java.io.IOException;

// Class declaration for CreateCodeSnippetController
public class CreateCodeSnippetController {

    // Private member variable to hold CreateCodeSnippetInputBoundary instance
    final CreateCodeSnippetInputBoundary createCodeSnippetInteractor;

    // Constructor to initialize CreateCodeSnippetController with CreateCodeSnippetInputBoundary
    public CreateCodeSnippetController(CreateCodeSnippetInputBoundary createCodeSnippetInteractor) {
        this.createCodeSnippetInteractor = createCodeSnippetInteractor;
    }

    // Method to execute the creation of a code snippet
    public void execute(String code, String noteText, String noteTitle, int noteID) throws IOException {
        // Create CreateCodeSnippetInputData instance with provided parameters
        CreateCodeSnippetInputData createCodeSnippetInputData = new CreateCodeSnippetInputData(code, noteText, noteTitle, noteID);

        // Execute the create code snippet use case
        this.createCodeSnippetInteractor.execute(createCodeSnippetInputData);
    }
}
