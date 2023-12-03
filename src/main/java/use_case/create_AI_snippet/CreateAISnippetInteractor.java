// Package declaration indicating the location of the class within the project structure
package use_case.create_AI_snippet;

// Import statements for classes from different packages
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the CreateAISnippetInteractor class implementing the CreateAISnippetInputBoundary interface
public class CreateAISnippetInteractor implements CreateAISnippetInputBoundary {

    // Instance variables to hold references to the data access object and the output boundary presenter
    private final CreateAISnippetDataAccessInterface createAISnippetDataAccessObject;
    private final EditNoteOutputBoundary editNotePresenter;

    // Constructor for the CreateAISnippetInteractor class, taking two parameters
    public CreateAISnippetInteractor(CreateAISnippetDataAccessInterface createAISnippetDataAccessObject,
                                     EditNoteOutputBoundary editNotePresenter) {
        // Assign the provided references to the corresponding instance variables
        this.createAISnippetDataAccessObject = createAISnippetDataAccessObject;
        this.editNotePresenter = editNotePresenter;
    }

    // Implementation of the execute method defined in the CreateAISnippetInputBoundary interface
    @Override
    public void execute(CreateAISnippetInputData createAISnippetInputData) throws IOException {
        // Unpack data from the input object
        String prompt = createAISnippetInputData.getPrompt();
        String currentText = createAISnippetInputData.getNoteText();
        String noteTitle = createAISnippetInputData.getNoteTitle();
        int noteID = createAISnippetInputData.getNoteID();

        // Use the DAO to invoke the API and retrieve the AI response
        StringBuilder response = createAISnippetDataAccessObject.getResponse(prompt);

        // Convert the response to a string
        String aiResponse = new String(response);

        // Concatenate the AI response to the existing note text with proper formatting
        String noteText = currentText + "\nAI Snippet Output:\n" + aiResponse;

        // Prepare the output data and notify the presenter
        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteID, noteTitle, noteText);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}
