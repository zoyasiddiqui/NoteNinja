package entity.AISnippet;

// Import statements
import entity.AISnippet.AISnippet;

// Class declaration for CommonAISnippet implementing AISnippet
public class CommonAISnippet implements AISnippet {

    // Private fields to store snippet question and response
    private String snippetQuestion;
    private String snippetResponse;

    // Implementation of the setSnippetQuestion method
    @Override
    public void setSnippetQuestion(String question) {
        this.snippetQuestion = question;
    }

    // Implementation of the setResponse method
    @Override
    public void setResponse(String response) {
        this.snippetResponse = response;
    }

    // Implementation of the getSnippetQuestion method
    @Override
    public String getSnippetQuestion() {
        return snippetQuestion;
    }

}
