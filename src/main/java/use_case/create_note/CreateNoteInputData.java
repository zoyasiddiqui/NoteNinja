package use_case.create_note;

public class CreateNoteInputData {
    private final String noteTitle;
    private final String noteText;

    public CreateNoteInputData(String noteTitle, String noteText) {
        this.noteTitle = noteTitle;
        this.noteText = noteText;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public String getNoteText() {
        return noteText;
    }
}