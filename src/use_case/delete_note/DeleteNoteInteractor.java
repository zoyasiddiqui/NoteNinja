package use_case.delete_note;

import entity.Note.Note;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;

public class DeleteNoteInteractor implements DeleteNoteInputBoundary {
    private final EditNoteDataAccessInterface editNoteDataAccessInterface;
    private final EditNoteOutputBoundary editNotePresenter;

    public DeleteNoteInteractor(EditNoteDataAccessInterface editNoteDataAccessInterface,
                                EditNoteOutputBoundary editNotePresenter) {
        this.editNoteDataAccessInterface = editNoteDataAccessInterface;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(String noteId) throws IOException {

    }
}
