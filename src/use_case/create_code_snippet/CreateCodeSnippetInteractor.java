package use_case.create_code_snippet;

import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;

public class CreateCodeSnippetInteractor implements CreateCodeSnippetInputBoundary {
    private final CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject;
    private final EditNoteDataAccessInterface editNoteDAO;
    private final EditNoteOutputBoundary editNotePresenter;

    public CreateCodeSnippetInteractor(CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject, EditNoteDataAccessInterface editNoteDAO, EditNoteOutputBoundary editNotePresenter) {
        this.createCodeSnippetDataAccessObject = createCodeSnippetDataAccessObject;
        this.editNoteDAO = editNoteDAO;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(String code) throws IOException {
        // Use the DAO to execute the code and get the response
        StringBuilder output = createCodeSnippetDataAccessObject.executeCode(code);

        // Update the text with the code snippet output
        String text = editNoteDAO.getCurrentText() + new String(output);
        editNoteDAO.setCurrentText(text);

        // Prepare the output data and notify the presenter
        CreateCodeSnippetOutputData createCodeSnippetOutputData = new CreateCodeSnippetOutputData(text);
        editNotePresenter.prepareSuccessView(createCodeSnippetOutputData);
    }
}
