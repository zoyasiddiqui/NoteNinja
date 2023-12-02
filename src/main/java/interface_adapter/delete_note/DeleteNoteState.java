package interface_adapter.delete_note;

public class DeleteNoteState {
    private String noteTitle = "";

    public DeleteNoteState(DeleteNoteState copy) {
        noteTitle = copy.noteTitle;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public DeleteNoteState() {}

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }
}
