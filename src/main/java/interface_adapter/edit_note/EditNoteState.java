package interface_adapter.edit_note;

public class EditNoteState {

    private String noteTitle;
    private String noteText;
    private int noteID;

    public EditNoteState(EditNoteState copy) {
        noteTitle = copy.noteTitle;
        noteText = copy.noteText;
        noteID = copy.noteID;
    }

    // make default constructor explicit bc of copy instructor
    public EditNoteState() {}

    public String getNoteTitle() {
        return noteTitle;
    }
    public String getNoteText() {
        return noteText;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }
}
