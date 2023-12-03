// Package declaration indicating the location of the class within the project structure
package use_case.delete_note;

// Definition of the DeleteNoteInputData class
public class DeleteNoteInputData {

    // Private instance variable to store the note ID
    private final int noteID;

    // Constructor for initializing the DeleteNoteInputData object
    public DeleteNoteInputData(int noteID) {
        this.noteID = noteID;
    }

    // Getter method to retrieve the note ID value
    public int getNoteID() {
        return noteID;
    }
}
