package interface_adapter.create_code_snippet;
import use_case.create_code_snippet.CreateCodeSnippetInputBoundary;

import java.io.IOException;

public class CodeController{
    final CreateCodeSnippetInputBoundary createCodeSnippetInteractor;

    public CodeController(CreateCodeSnippetInputBoundary createCodeSnippetInteractor) {
        this.createCodeSnippetInteractor = createCodeSnippetInteractor;
    }

    public void execute(String code, String output) throws IOException {
        this.createCodeSnippetInteractor.execute(code, output);
    }
}