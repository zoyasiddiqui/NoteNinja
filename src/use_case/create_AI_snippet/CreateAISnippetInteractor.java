package use_case.create_AI_snippet;

import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

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
    public void execute(String prompt) {
        //use the DAO to use the API to give us back the AI response
        StringBuilder response = createAISnippetDataAccessObject.getResponse(prompt);
        String text = editNoteDAO.getCurrentText() + new String(response);
        // create a note entity using the InputData

        System.out.println(text);
        editNoteDAO.setCurrentText(text);

        CreateAISnippetOutputData createAISnippetOutputData = new CreateAISnippetOutputData(text);
        editNotePresenter.prepareSnippetAdded(createAISnippetOutputData);
    }
}