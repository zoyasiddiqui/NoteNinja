package use_case.create_code_snippet;

import interface_adapter.edit_note.EditNoteState;
import use_case.create_note.CreateNoteInputData;

public class CreateCodeSnippetInputData {
    final private String code;
    final private String text;
    final private EditNoteState editNoteState;

    public CreateCodeSnippetInputData(String code, String text, EditNoteState editNoteState) {
        this.code = code;
        this.text = text;
        this.editNoteState = editNoteState;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public EditNoteState getNoteState() {
        return editNoteState;
    }
}
