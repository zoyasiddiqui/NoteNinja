// Package declaration indicating the location of the class within the project structure
package use_case.edit_note;

// Definition of the EditNoteOutputData class
public class EditNoteOutputData {

    // Private instance variables to store note title, note text, and note ID
    private String noteTitle;
    private String noteText;
    private int noteID;

    // Constructor for initializing the EditNoteOutputData object
    public EditNoteOutputData(int noteID, String noteTitle, String noteText) {
        this.noteTitle = noteTitle;
        this.noteText = noteText;
        this.noteID = noteID;
    }

    // Getter method to retrieve the note title
    public String getNoteTitle() {
        return noteTitle;
    }

    // Getter method to retrieve the note text
    public String getNoteText() {
        return noteText;
    }

    // Getter method to retrieve the note ID
    public int getNoteID() {
        return noteID;
    }
}
