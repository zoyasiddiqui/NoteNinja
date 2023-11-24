package use_case.save_note;

import entity.Note.Note;
import entity.Note.NoteFactory;
import interface_adapter.edit_note.EditNotePresenter;
import use_case.edit_note.EditNoteDataAccessInterface;

import java.io.IOException;

public class SaveNoteInteractor implements SaveNoteInputBoundary{

    private final EditNoteDataAccessInterface editNoteDAO;
    private final NoteFactory noteFactory;

    public SaveNoteInteractor(EditNoteDataAccessInterface editNoteDAO,
                              NoteFactory noteFactory) {
        this.editNoteDAO = editNoteDAO;
        this.noteFactory = noteFactory;
    }

    @Override
    public void execute(SaveNoteInputData saveNoteInputData) throws IOException {
        // create a note entity using the InputData
        Note note = noteFactory.create(saveNoteInputData.getNoteTitle(), saveNoteInputData.getNoteText());
        editNoteDAO.save(note);
    }
}