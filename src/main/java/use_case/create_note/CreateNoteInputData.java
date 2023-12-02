package use_case.create_note;

public class CreateNoteInputData {
    String noteTitle;

    public CreateNoteInputData(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteTitle() {
        return this.noteTitle;
    }
}