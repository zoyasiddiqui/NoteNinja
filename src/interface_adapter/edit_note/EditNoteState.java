package interface_adapter.edit_note;

import entity.Note.Note;

public class EditNoteState {
    private String noteTitle;
    private String noteText;
    private String noteID;

    public EditNoteState(EditNoteState copy) {
        noteTitle = copy.noteTitle;
        noteText = copy.noteText;
        noteID = copy.noteID;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public EditNoteState() {}

    public String getNoteTitle() {
        return noteTitle;
    }
    public String getNoteText() {
        return noteText;
    }

    public String getNoteID() {
        return noteID;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public void setNoteID(String noteID) {
        this.noteID = noteID;
    }
}
