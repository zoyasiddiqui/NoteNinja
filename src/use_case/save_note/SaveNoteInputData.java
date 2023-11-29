package use_case.save_note;

public class SaveNoteInputData{
    final private String noteTitle;
    final private String noteText;
    final private int noteID;
    // TODO: figure out how we identify notes in our API database and construct the InputData with the proper ID

    public SaveNoteInputData (String noteTitle, String noteText, int noteID) {
        this.noteID = noteID;
        this.noteText = noteText;
        this.noteTitle = noteTitle;
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