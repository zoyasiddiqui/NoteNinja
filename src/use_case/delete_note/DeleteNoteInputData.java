package use_case.delete_note;

public class DeleteNoteInputData {
    private final int noteID;

    public DeleteNoteInputData(int noteID) {
        this.noteID = noteID;
    }

    public int getNoteID() {
        return noteID;
    }
}
