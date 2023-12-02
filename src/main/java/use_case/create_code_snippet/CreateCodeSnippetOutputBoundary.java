package use_case.create_code_snippet;

public interface CreateCodeSnippetOutputBoundary {

    void prepareSuccessView(CreateCodeSnippetOutputData response);

    void prepareFailView(String error);

}
