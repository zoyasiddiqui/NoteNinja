package use_case.create_code_snippet;

import interface_adapter.edit_note.EditNoteState;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

public class CreateCodeSnippetInteractor implements CreateCodeSnippetInputBoundary {
    private final CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject;
    private final EditNoteDataAccessInterface editNoteDAO;
    private final EditNoteOutputBoundary editNotePresenter;

    public CreateCodeSnippetInteractor(CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject,
                                       EditNoteDataAccessInterface editNoteDAO, EditNoteOutputBoundary editNotePresenter) {
        this.createCodeSnippetDataAccessObject = createCodeSnippetDataAccessObject;
        this.editNoteDAO = editNoteDAO;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(CreateCodeSnippetInputData createCodeSnippetInputData) throws IOException {

        EditNoteState editNoteState = createCodeSnippetInputData.getNoteState();
        String code = createCodeSnippetInputData.getCode();
        String text = createCodeSnippetInputData.getText();
        // use the DAO to execute the code and get the response
        StringBuilder output = createCodeSnippetDataAccessObject.executeCode(code);

        // update current text with new text. note we do NOT retrieve the current text from our editNoteDAO, we get it from note state
        String newText = text + new String(output);

        // prepare the output data and notify the presenter
        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(editNoteState.getNoteID(), editNoteState.getNoteTitle(), newText);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}
