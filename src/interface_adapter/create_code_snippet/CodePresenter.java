package interface_adapter.create_code_snippet;

import use_case.create_AI_snippet.CreateAISnippetOutputBoundary;
import use_case.create_AI_snippet.CreateAISnippetOutputData;
import use_case.create_code_snippet.CreateCodeSnippetOutputBoundary;
import use_case.create_code_snippet.CreateCodeSnippetOutputData;

public class CodePresenter implements CreateAISnippetOutputBoundary {

    @Override
    public void prepareSuccessView(CreateAISnippetOutputData response) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}