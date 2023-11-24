package interface_adapter.create_AI_snippet;

import use_case.create_AI_snippet.CreateAISnippetInputBoundary;

import java.io.IOException;

public class CreateAISnippetController {

    final CreateAISnippetInputBoundary createAISnippetInteractor;

    public CreateAISnippetController(CreateAISnippetInputBoundary createAISnippetInteractor) {
        this.createAISnippetInteractor = createAISnippetInteractor;
    }

    public void execute(String prompt) throws IOException {
        this.createAISnippetInteractor.execute(prompt);
    }
}