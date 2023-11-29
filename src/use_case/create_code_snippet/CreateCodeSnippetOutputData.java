package use_case.create_code_snippet;

public class CreateCodeSnippetOutputData {
    private String text;

    public CreateCodeSnippetOutputData(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
