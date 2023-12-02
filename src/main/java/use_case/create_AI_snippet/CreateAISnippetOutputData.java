package use_case.create_AI_snippet;

public class CreateAISnippetOutputData {
    private String text;

    public  CreateAISnippetOutputData(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}