// Package declaration indicating the location of the class within the project structure
package use_case.create_code_snippet;

// Import statements for classes from different packages
import interface_adapter.edit_note.EditNoteState;
import use_case.create_note.CreateNoteInputData;

// Definition of the CreateCodeSnippetInputData class
public class CreateCodeSnippetInputData {

    // Private instance variables to store input data
    final private String code;
    final private String noteText;
    final private String noteTitle;
    final private int noteID;

    // Constructor for initializing the CreateCodeSnippetInputData object
    public CreateCodeSnippetInputData(String code, String noteText, String noteTitle, int noteID) {
        this.code = code;
        this.noteText = noteText;
        this.noteTitle = noteTitle;
        this.noteID = noteID;
    }

    // Getter method to retrieve the code value
    public String getCode() {
        return code;
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
