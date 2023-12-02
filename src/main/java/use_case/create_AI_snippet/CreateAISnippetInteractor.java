package use_case.create_AI_snippet;

import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteState;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

public class CreateAISnippetInteractor implements CreateAISnippetInputBoundary{
    private final CreateAISnippetDataAccessInterface createAISnippetDataAccessObject;
    private final EditNoteDataAccessInterface editNoteDAO;
    private final EditNoteOutputBoundary editNotePresenter;

    public CreateAISnippetInteractor(CreateAISnippetDataAccessInterface createAISnippetDataAccessObject, EditNoteDataAccessInterface editNoteDAO, EditNoteOutputBoundary editNotePresenter) {
        this.createAISnippetDataAccessObject = createAISnippetDataAccessObject;
        this.editNoteDAO = editNoteDAO;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(String prompt, String noteText, EditNoteState editNoteState) throws IOException {
        // Use the DAO to use the API to give us back the AI response
        StringBuilder response = createAISnippetDataAccessObject.getResponse(prompt);

        // Convert the response to a string
        String aiResponse = new String(response);

        // Concatenate the AI response to the existing note text with proper formatting
        String text = noteText + "\nAI Snippet Output:\n" + aiResponse;

        // Update the note using the DAO
        editNoteDAO.updateNote(editNoteState.getNoteID(), text, editNoteState.getNoteTitle());

        // Prepare the output data and notify the presenter
        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(editNoteState.getNoteID(), editNoteState.getNoteTitle(), text);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}