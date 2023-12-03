// Package declaration indicating the location of the class within the project structure
package use_case.create_code_snippet;

// Import statements for classes from different packages
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the CreateCodeSnippetInteractor class implementing the CreateCodeSnippetInputBoundary interface
public class CreateCodeSnippetInteractor implements CreateCodeSnippetInputBoundary {

    // Instance variables to hold references to the data access object and the output boundary presenter
    private final CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject;
    private final EditNoteOutputBoundary editNotePresenter;

    // Constructor for the CreateCodeSnippetInteractor class, taking two parameters
    public CreateCodeSnippetInteractor(CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject,
                                       EditNoteOutputBoundary editNotePresenter) {
        // Assign the provided references to the corresponding instance variables
        this.createCodeSnippetDataAccessObject = createCodeSnippetDataAccessObject;
        this.editNotePresenter = editNotePresenter;
    }

    // Implementation of the execute method defined in the CreateCodeSnippetInputBoundary interface
    @Override
    public void execute(CreateCodeSnippetInputData createCodeSnippetInputData) throws IOException {

        // Unpack data from the input object
        String code = createCodeSnippetInputData.getCode();
        String currentText = createCodeSnippetInputData.getNoteText();

        // Use the DAO to execute the code and get the response
        StringBuilder output = createCodeSnippetDataAccessObject.executeCode(code);

        // Convert the response to a string
        String codeReturn = new String(output);

        // Set appropriate amount of newline characters based on existing text
        String newText = calculateNewText(currentText);

        // Concatenate the executed code and response to the existing note text with proper formatting
        newText = currentText + newText + "Ran code snippet:\n---\n" + code + "\n---\n" + codeReturn;

        // Prepare the output data and notify the presenter
        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(
                createCodeSnippetInputData.getNoteID(),
                createCodeSnippetInputData.getNoteTitle(),
                newText);
        editNotePresenter.prepareNote(editNoteOutputData);
    }

    // Helper method to calculate the appropriate newline characters to add based on existing text
    String calculateNewText(String currentText) {
        String newText = "\n\n";
        int length = currentText.length();

        if (length > 0) {
            if (currentText.charAt(length - 1) == '\n') {
                newText = "\n";
            }
            if (length > 2 && currentText.charAt(length - 1) == '\n' && currentText.charAt(length - 2) == '\n') {
                newText = "";
            }
        }

        return newText;
    }
}
