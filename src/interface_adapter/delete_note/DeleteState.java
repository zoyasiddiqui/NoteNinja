package interface_adapter.delete_note;

public class DeleteState {
    private String noteTitle = "";

    public DeleteState(DeleteState copy) {
        noteTitle = copy.noteTitle;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public DeleteState() {}

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }
}
