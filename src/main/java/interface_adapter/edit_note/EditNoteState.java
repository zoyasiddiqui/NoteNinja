// Package declaration
package interface_adapter.edit_note;

// Class declaration for EditNoteState
public class EditNoteState {

    // Instance variables for note title, note text, and note ID
    private String noteTitle;
    private String noteText;
    private int noteID;

    // Constructor to create a copy of EditNoteState
    public EditNoteState(EditNoteState copy) {
        noteTitle = copy.noteTitle;
        noteText = copy.noteText;
        noteID = copy.noteID;
    }

    // Explicit default constructor due to the presence of a copy constructor
    public EditNoteState() {}

    // Getter method for retrieving note title
    public String getNoteTitle() {
        return noteTitle;
    }

    // Getter method for retrieving note text
    public String getNoteText() {
        return noteText;
    }

    // Getter method for retrieving note ID
    public int getNoteID() {
        return noteID;
    }

    // Setter method for setting note title
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    // Setter method for setting note text
    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    // Setter method for setting note ID
    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
}
