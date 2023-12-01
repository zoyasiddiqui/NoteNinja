package use_case.create_AI_snippet;

import use_case.save_note.SaveNoteInputData;

import java.io.IOException;

public interface CreateAISnippetInputBoundary {

    void execute(String prompt, String noteText);

}