package use_case.save_note;

import entity.Note.Note;
import interface_adapter.save_note.SavePresenter;
import use_case.edit_note.EditNoteDataAccessInterface;

import java.io.IOException;

public class SaveNoteInteractor implements SaveNoteInputBoundary{

    private final Note note;
    private final EditNoteDataAccessInterface editNoteDAO;
    private final SavePresenter savePresenter;

    public SaveNoteInteractor(Note note, EditNoteDataAccessInterface editNoteDAO, SavePresenter savePresenter) {
        this.note = note;
        this.editNoteDAO = editNoteDAO;
        this.savePresenter = savePresenter;
    }

    @Override
    public void execute() throws IOException {
        editNoteDAO.save(note);
        savePresenter.prepareSuccessView();
    }
}