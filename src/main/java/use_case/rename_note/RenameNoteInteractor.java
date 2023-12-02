package use_case.rename_note;

import interface_adapter.edit_note.EditNotePresenter;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import use_case.save_note.SaveNoteInputData;

import java.io.IOException;

public class RenameNoteInteractor implements RenameNoteInputBoundary {
    final EditNoteOutputBoundary editNotePresenter;
    final EditNoteDataAccessInterface editNoteDataAccessObject;

    public RenameNoteInteractor (EditNoteOutputBoundary editNotePresenter,
                                 EditNoteDataAccessInterface editNoteDataAccessObject) {
        this.editNotePresenter = editNotePresenter;
        this.editNoteDataAccessObject = editNoteDataAccessObject;
    }

    @Override
    public void execute(SaveNoteInputData saveNoteInputData) throws IOException {
        String noteTitle = saveNoteInputData.getNoteTitle();
        RenameNoteOutputData renameNoteOutputData = new RenameNoteOutputData(noteTitle);

        editNoteDataAccessObject.updateNote(saveNoteInputData.getNoteID(),
                saveNoteInputData.getNoteText(), saveNoteInputData.getNoteTitle());

        editNotePresenter.prepareTitleChange(renameNoteOutputData);
    }
}
