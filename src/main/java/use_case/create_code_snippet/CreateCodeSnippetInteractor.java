package use_case.create_code_snippet;

import interface_adapter.edit_note.EditNoteState;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

public class CreateCodeSnippetInteractor implements CreateCodeSnippetInputBoundary {
    private final CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject;
    private final EditNoteOutputBoundary editNotePresenter;
    private final String dashes = "\n---\n";

    public CreateCodeSnippetInteractor(CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject,
                                       EditNoteOutputBoundary editNotePresenter) {
        this.createCodeSnippetDataAccessObject = createCodeSnippetDataAccessObject;
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
        String codeReturn = new String(output);
        System.out.println(codeReturn);

        // set appropriate amount of newline characters
        String newText = "\n\n";
        int l = text.length();
        if (text.isEmpty()) {
            newText = "";
        } else if (text.charAt(l - 1) == '\n') {
            System.out.println("bababooey");
            newText = "\n";
        } if (l > 2) {
            if (text.charAt(l - 1) == '\n' && text.charAt(l - 2) == '\n') {
                newText = "";
            }
        }

        newText = text + newText + "Ran code snippet:" + dashes + code + dashes + codeReturn;

        // prepare the output data and notify the presenter
        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(editNoteState.getNoteID(), editNoteState.getNoteTitle(), newText);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}
