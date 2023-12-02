package use_case.edit_note;

public class EditNoteOutputData {

    private String noteTitle;
    private String noteText;
    private int noteID;

    public EditNoteOutputData(int noteID, String noteTitle, String noteText) {
        this.noteTitle = noteTitle;
        this.noteText = noteText;
        this.noteID = noteID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }

    public int getNoteID() {
        return noteID;
    }
}