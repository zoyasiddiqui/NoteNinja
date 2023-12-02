package use_case.create_AI_snippet;

import interface_adapter.edit_note.EditNoteState;

import java.io.IOException;

public interface CreateAISnippetInputBoundary {

    void execute(String prompt, String noteText, EditNoteState editNoteState) throws IOException;

}