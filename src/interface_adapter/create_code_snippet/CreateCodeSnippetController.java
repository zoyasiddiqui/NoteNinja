package interface_adapter.create_code_snippet;

import use_case.create_code_snippet.CreateCodeSnippetInputBoundary;

import java.io.IOException;

public class CreateCodeSnippetController {

    private final CreateCodeSnippetInputBoundary createCodeSnippetInteractor;

    public CreateCodeSnippetController(CreateCodeSnippetInputBoundary createCodeSnippetInteractor) {
        this.createCodeSnippetInteractor = createCodeSnippetInteractor;
    }

    public void execute(String code) throws IOException {
        this.createCodeSnippetInteractor.execute(code);
    }
}
