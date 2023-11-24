package use_case.delete_note;

public class DeleteNoteInputData {
    private final String noteID;

    public DeleteNoteInputData(String noteID) {
        this.noteID = noteID;
    }

    public String getNoteID() {
        return noteID;
    }
}
