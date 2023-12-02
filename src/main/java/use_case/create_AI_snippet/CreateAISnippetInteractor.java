package use_case.create_AI_snippet;

import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

public class CreateAISnippetInteractor implements CreateAISnippetInputBoundary{
    private final CreateAISnippetDataAccessInterface createAISnippetDataAccessObject;

    private final EditNoteOutputBoundary editNotePresenter;

    public CreateAISnippetInteractor(CreateAISnippetDataAccessInterface createAISnippetDataAccessObject,
                                     EditNoteOutputBoundary editNotePresenter) {
        this.createAISnippetDataAccessObject = createAISnippetDataAccessObject;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(CreateAISnippetInputData createAISnippetInputData) throws IOException {
        // unpack data
        String prompt = createAISnippetInputData.getPrompt();
        String currentText = createAISnippetInputData.getNoteText();
        String noteTitle = createAISnippetInputData.getNoteTitle();
        int noteID = createAISnippetInputData.getNoteID();

        // Use the DAO to use the API to give us back the AI response
        StringBuilder response = createAISnippetDataAccessObject.getResponse(prompt);

        // Convert the response to a string
        String aiResponse = new String(response);

        // Concatenate the AI response to the existing note noteText with proper formatting
        String noteText = currentText + "\nAI Snippet Output:\n" + aiResponse;

        // Prepare the output data and notify the presenter
        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteID, noteTitle, noteText);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}