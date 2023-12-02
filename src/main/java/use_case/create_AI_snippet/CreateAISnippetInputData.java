package use_case.create_AI_snippet;

public class CreateAISnippetInputData {
    private final String prompt;
    private final String noteText;
    private final String noteTitle;
    private final int noteID;
    public CreateAISnippetInputData(String prompt, String noteText, String noteTitle, int noteID) {
        this.prompt = prompt;
        this.noteText = noteText;
        this.noteTitle = noteTitle;
        this.noteID = noteID;
    }

    public String getPrompt() {
        return prompt;
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