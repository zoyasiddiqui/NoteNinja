package use_case.create_code_snippet;

import java.io.IOException;

public interface CreateCodeSnippetInputBoundary {

    void execute(CreateCodeSnippetInputData createCodeSnippetInputData) throws IOException;

}
