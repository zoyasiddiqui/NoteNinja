// Package declaration indicating the location of the class within the project structure
package use_case.rename_note;

// Definition of the RenameNoteInputData class
public class RenameNoteInputData {

    // Private instance variable to store the new note title
    private final String noteTitle;

    // Constructor for initializing the RenameNoteInputData object with a note title
    public RenameNoteInputData(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    // Getter method to retrieve the new note title
    String getNoteTitle() {
        return this.noteTitle;
    }
}
