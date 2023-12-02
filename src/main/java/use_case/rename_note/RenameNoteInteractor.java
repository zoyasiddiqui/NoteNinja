package use_case.rename_note;

import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;

public class RenameNoteInteractor implements RenameNoteInputBoundary {
    final EditNoteOutputBoundary editNotePresenter;

    public RenameNoteInteractor (EditNoteOutputBoundary editNotePresenter) {
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(RenameNoteInputData renameNoteInputData) throws IOException {
        String noteTitle = renameNoteInputData.getNoteTitle();
        RenameNoteOutputData renameNoteOutputData = new RenameNoteOutputData(noteTitle);
        editNotePresenter.prepareTitleChange(renameNoteOutputData);
    }
}
