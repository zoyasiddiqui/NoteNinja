// Package declaration
package interface_adapter.create_AI_snippet;

// Import statements for various classes and interfaces
import use_case.create_AI_snippet.CreateAISnippetInputBoundary;
import use_case.create_AI_snippet.CreateAISnippetInputData;

import java.io.IOException;

// Class declaration for CreateAISnippetController
public class CreateAISnippetController {

    // Private member variable to hold the CreateAISnippetInteractor instance
    final CreateAISnippetInputBoundary createAISnippetInteractor;

    // Constructor to initialize the CreateAISnippetController with a CreateAISnippetInteractor instance
    public CreateAISnippetController(CreateAISnippetInputBoundary createAISnippetInteractor) {
        this.createAISnippetInteractor = createAISnippetInteractor;
    }

    // Public method to execute the CreateAISnippetInteractor
    public void execute(String prompt, String noteText, String noteTitle, int noteID) throws IOException {
        // Create input data for the CreateAISnippetInteractor
        CreateAISnippetInputData createAISnippetInputData = new CreateAISnippetInputData(prompt, noteText, noteTitle, noteID);

        // Delegates the execution to the CreateAISnippetInteractor
        this.createAISnippetInteractor.execute(createAISnippetInputData);
    }
}
