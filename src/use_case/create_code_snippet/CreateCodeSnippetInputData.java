package use_case.create_code_snippet;

import use_case.create_note.CreateNoteInputData;

public class CreateCodeSnippetInputData {
    final private String code;

    public CreateCodeSnippetInputData(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
