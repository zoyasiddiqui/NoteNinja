// Package declaration indicating the location of the class within the project structure
package use_case.create_note;

// Definition of the CreateNoteInputData class
public class CreateNoteInputData {

    // Private instance variables to store input data
    private final String noteTitle;
    private final String noteText;

    // Constructor for initializing the CreateNoteInputData object
    public CreateNoteInputData(String noteTitle, String noteText) {
        this.noteTitle = noteTitle;
        this.noteText = noteText;
    }

    // Getter method to retrieve the noteTitle value
    public String getNoteTitle() {
        return noteTitle;
    }

    // Getter method to retrieve the noteText value
    public String getNoteText() {
        return noteText;
    }
}
