package use_case.create_code_snippet;

import interface_adapter.edit_note.EditNoteState;
import use_case.create_note.CreateNoteInputData;

public class CreateCodeSnippetInputData {
    final private String code;
    final private String noteText;
    final private String noteTitle;
    final private int noteID;

    public CreateCodeSnippetInputData(String code, String noteText, String noteTitle, int noteID) {
        this.code = code;
        this.noteText = noteText;
        this.noteTitle = noteTitle;
        this.noteID = noteID;
    }

    public String getCode() {
        return code;
    }

    public String getNoteText() {
        return noteText;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public int getNoteID() {
        return noteID;
    }
}
