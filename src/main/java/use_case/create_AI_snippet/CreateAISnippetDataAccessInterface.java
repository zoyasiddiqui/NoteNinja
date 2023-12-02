package use_case.create_AI_snippet;

public interface CreateAISnippetDataAccessInterface {
    StringBuilder getResponse(String prompt);
}