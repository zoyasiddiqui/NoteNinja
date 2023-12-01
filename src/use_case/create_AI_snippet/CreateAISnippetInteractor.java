package use_case.create_AI_snippet;

import interface_adapter.edit_note.EditNoteState;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;

public class CreateAISnippetInteractor implements CreateAISnippetInputBoundary{
    private final CreateAISnippetDataAccessInterface createAISnippetDataAccessObject;
    private final EditNoteDataAccessInterface editNoteDAO;
    private final CreateAISnippetOutputBoundary createAISnippetPresenter;

    public CreateAISnippetInteractor(CreateAISnippetDataAccessInterface createAISnippetDataAccessObject, EditNoteDataAccessInterface editNoteDAO, CreateAISnippetOutputBoundary createAISnippetPresenter) {
        this.createAISnippetDataAccessObject = createAISnippetDataAccessObject;
        this.editNoteDAO = editNoteDAO;
        this.createAISnippetPresenter = createAISnippetPresenter;
    }

    @Override
    public void execute(String prompt, String noteText, EditNoteState editNoteState) throws IOException {
        //use the DAO to use the API to give us back the AI response
        StringBuilder response = createAISnippetDataAccessObject.getResponse(prompt);
        String text = noteText + new String(response);
        editNoteDAO.updateNote(editNoteState.getNoteID(), noteText, editNoteState.getNoteTitle());
        // create a note entity using the InputData

        CreateAISnippetOutputData createAISnippetOutputData = new CreateAISnippetOutputData(text);
        createAISnippetPresenter.prepareSuccessView(createAISnippetOutputData);
    }
}