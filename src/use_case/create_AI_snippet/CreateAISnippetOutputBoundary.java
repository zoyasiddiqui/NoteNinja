package use_case.create_AI_snippet;
import use_case.create_AI_snippet.CreateAISnippetOutputData;
public interface CreateAISnippetOutputBoundary {

    void prepareSuccessView(CreateAISnippetOutputData response);

    void prepareFailView(String error);

}