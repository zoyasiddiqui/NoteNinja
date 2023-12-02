package use_case.create_AI_snippet;
public interface CreateAISnippetOutputBoundary {

    void prepareSuccessView(CreateAISnippetOutputData response);

    void prepareFailView(String error);

}