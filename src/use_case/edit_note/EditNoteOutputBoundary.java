package use_case.edit_note;

import use_case.create_AI_snippet.CreateAISnippetOutputData;
import use_case.rename_note.RenameNoteOutputData;

public interface EditNoteOutputBoundary {
    void prepareNote(EditNoteOutputData note);

    void prepareTitleChange(RenameNoteOutputData title);

    void prepareSnippetAdded(CreateAISnippetOutputData text);

    void noteDeletedSuccessfully();

    void prepareBackMenu();
}