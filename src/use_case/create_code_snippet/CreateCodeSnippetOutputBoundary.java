package use_case.create_code_snippet;

import use_case.create_AI_snippet.CreateAISnippetOutputData;

public interface CreateCodeSnippetOutputBoundary {

    void prepareSuccessView(CreateCodeSnippetOutputBoundary output);
    void prepareFailView(String error);

}