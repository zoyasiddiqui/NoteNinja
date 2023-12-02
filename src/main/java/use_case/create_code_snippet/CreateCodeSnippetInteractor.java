package use_case.create_code_snippet;

import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

public class CreateCodeSnippetInteractor implements CreateCodeSnippetInputBoundary {
    private final CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject;
    private final EditNoteOutputBoundary editNotePresenter;

    public CreateCodeSnippetInteractor(CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject,
                                       EditNoteOutputBoundary editNotePresenter) {
        this.createCodeSnippetDataAccessObject = createCodeSnippetDataAccessObject;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(CreateCodeSnippetInputData createCodeSnippetInputData) throws IOException {

        String code = createCodeSnippetInputData.getCode();
        String currentText = createCodeSnippetInputData.getNoteText();
        // use the DAO to execute the code and get the response
        StringBuilder output = createCodeSnippetDataAccessObject.executeCode(code);

        // update current currentText with new currentText. note we do NOT retrieve the current currentText from our editNoteDAO, we get it from note state
        String codeReturn = new String(output);
        System.out.println(codeReturn);

        // set appropriate amount of newline characters
        String newText = "\n\n";
        int l = currentText.length();
        if (currentText.isEmpty()) {
            newText = "";
        } else if (currentText.charAt(l - 1) == '\n') {
            System.out.println("bababooey");
            newText = "\n";
        } if (l > 2) {
            if (currentText.charAt(l - 1) == '\n' && currentText.charAt(l - 2) == '\n') {
                newText = "";
            }
        }

        String dashes = "\n---\n";
        newText = currentText + newText + "Ran code snippet:" + dashes + code + dashes + codeReturn;

        // prepare the output data and notify the presenter
        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(
                createCodeSnippetInputData.getNoteID(),
                createCodeSnippetInputData.getNoteTitle(),
                newText);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}
