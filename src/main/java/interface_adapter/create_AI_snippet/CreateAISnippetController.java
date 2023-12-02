package interface_adapter.create_AI_snippet;

import interface_adapter.edit_note.EditNoteState;
import use_case.create_AI_snippet.CreateAISnippetInputBoundary;
import use_case.create_AI_snippet.CreateAISnippetInputData;
import use_case.save_note.SaveNoteInputData;

import java.io.IOException;

public class CreateAISnippetController {

    final CreateAISnippetInputBoundary createAISnippetInteractor;

    public CreateAISnippetController(CreateAISnippetInputBoundary createAISnippetInteractor) {
        this.createAISnippetInteractor = createAISnippetInteractor;
    }

    public void execute(String prompt, String noteText, String noteTitle, int noteID) throws IOException {
        CreateAISnippetInputData createAISnippetInputData = new CreateAISnippetInputData(prompt, noteText, noteTitle, noteID);
        this.createAISnippetInteractor.execute(createAISnippetInputData);
    }
}