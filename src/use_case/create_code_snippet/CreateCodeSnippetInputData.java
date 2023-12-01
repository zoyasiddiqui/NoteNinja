package use_case.create_code_snippet;

import use_case.create_note.CreateNoteInputData;

public class CreateCodeSnippetInputData {
    final private String code;
    final private String text;

    public CreateCodeSnippetInputData(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }
}
