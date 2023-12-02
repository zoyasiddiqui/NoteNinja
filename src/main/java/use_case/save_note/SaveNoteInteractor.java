package use_case.save_note;

import entity.Note.Note;
import entity.Note.NoteFactory;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

public class SaveNoteInteractor implements SaveNoteInputBoundary{

    private final EditNoteDataAccessInterface noteDataAccessObject;
    private final NoteFactory noteFactory;
    private final EditNoteOutputBoundary editNotePresenter;

    public SaveNoteInteractor(EditNoteDataAccessInterface noteDataAccessObject,
                              NoteFactory noteFactory,
                              EditNoteOutputBoundary editNotePresenter) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.noteFactory = noteFactory;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(SaveNoteInputData saveNoteInputData) throws IOException {
        int noteID = saveNoteInputData.getNoteID();

        // create a note entity using the InputData if note does not exist
        String noteText = saveNoteInputData.getNoteText();
        String noteTitle = saveNoteInputData.getNoteTitle();

        if (noteDataAccessObject.existsByID(noteID)) { // note already exists
            System.out.println("Note exists.");

            noteDataAccessObject.updateNote(noteID, noteText, noteTitle);
            System.out.println(noteDataAccessObject.getCurrentText());

            EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteID, noteTitle, noteText);
            editNotePresenter.prepareNote(editNoteOutputData);

        } else {
            Note note = noteFactory.create(noteTitle, noteText, noteID);
            ((CreateNoteDataAccessInterface) noteDataAccessObject).create(note);
        }
    }
}