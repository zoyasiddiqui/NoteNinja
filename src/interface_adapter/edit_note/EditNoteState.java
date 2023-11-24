package interface_adapter.edit_note;

import entity.Note.Note;

public class EditNoteState {
    private String noteTitle = "";
    private String text = "";
    private Note note;

    public EditNoteState(EditNoteState copy) {
        noteTitle = copy.noteTitle;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public EditNoteState() {}

    public String getNoteTitle() {
        return noteTitle;
    }
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }
    public String getText() {return this.text; }
    public void setText(String text) { this.text = text;}
    public Note getNote() {
        return this.note;
    }
    public void setNote(Note note) {
        this.note = note;
    }
}
