package use_case.edit_note;

import java.io.IOException;

public class EditNoteInteractor implements  EditNoteInputBoundary {
    final EditNoteDataAccessInterface editNoteDataAccessInterface;
    final EditNoteOutputBoundary editNotePresenter;

    public EditNoteInteractor (EditNoteDataAccessInterface editNoteDataAccessInterface,
                               EditNoteOutputBoundary editNotePresenter) {
        this.editNoteDataAccessInterface = editNoteDataAccessInterface;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute() throws IOException {

    }
}