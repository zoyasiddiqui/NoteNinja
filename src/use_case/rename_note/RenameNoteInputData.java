package use_case.rename_note;

public class RenameNoteInputData {
    private final String noteTitle;

    public RenameNoteInputData (String noteTitle) {
        this.noteTitle = noteTitle;
    }

    String getNoteTitle () {
        return this.noteTitle;
    }

}
