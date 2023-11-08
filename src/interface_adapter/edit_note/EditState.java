package interface_adapter.edit_note;

public class EditState {
    private String noteTitle = "";

    public EditState(EditState copy) {
        noteTitle = copy.noteTitle;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public EditState() {}

    public String getNoteTitle() {
        return noteTitle;
    }
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }
}
