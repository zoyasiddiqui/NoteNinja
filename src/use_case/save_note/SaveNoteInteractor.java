package use_case.save_note;

import data_access.NoteDataAccessObject;
import entity.Note.Note;
import entity.Note.NoteFactory;
import interface_adapter.edit_note.EditNotePresenter;
import use_case.edit_note.EditNoteDataAccessInterface;

import java.io.IOException;

public class SaveNoteInteractor implements SaveNoteInputBoundary{

    private final NoteDataAccessObject editNoteDAO;
    private final NoteFactory noteFactory;

    public SaveNoteInteractor(NoteDataAccessObject editNoteDAO,
                              NoteFactory noteFactory) {
        this.editNoteDAO = editNoteDAO;
        this.noteFactory = noteFactory;
    }

    @Override
    public void execute(SaveNoteInputData saveNoteInputData) throws IOException {
        // create a note entity using the InputData
        int noteID = saveNoteInputData.getNoteID();
        String noteText = saveNoteInputData.getNoteText();
        String noteTitle = saveNoteInputData.getNoteTitle();

        if (editNoteDAO.existsByID(noteID)) { // note already exists
            editNoteDAO.updateNote(noteID, noteText, noteTitle);

        } else { // else create a new note
            Note note = noteFactory.create(noteTitle, noteText);
            editNoteDAO.create(note);
        }
    }
}