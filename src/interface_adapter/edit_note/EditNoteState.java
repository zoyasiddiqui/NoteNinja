package interface_adapter.edit_note;

public class EditNoteState {
    private String noteTitle = "";

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
}
