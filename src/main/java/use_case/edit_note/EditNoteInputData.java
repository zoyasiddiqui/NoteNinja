// Package declaration indicating the location of the class within the project structure
package use_case.edit_note;

// Definition of the SaveNoteInputData class
public class EditNoteInputData {

    // Private instance variables to store note title, note text, and note ID
    final private String noteTitle;
    final private String noteText;
    final private int noteID;

    public EditNoteInputData(String noteTitle, String noteText, int noteID) {
        this.noteID = noteID;
        this.noteText = noteText;
        this.noteTitle = noteTitle;
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
