package interface_adapter.create_AI_snippet;

import use_case.create_AI_snippet.CreateAISnippetOutputBoundary;
import use_case.create_AI_snippet.CreateAISnippetOutputData;

public class CreateAISnippetPresenter implements CreateAISnippetOutputBoundary {

    @Override
    public void prepareSuccessView(CreateAISnippetOutputData response) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}