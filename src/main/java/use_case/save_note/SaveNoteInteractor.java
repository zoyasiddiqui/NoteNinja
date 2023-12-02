package use_case.save_note;

import entity.Note.Note;
import entity.Note.NoteFactory;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteState;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

public class SaveNoteInteractor implements SaveNoteInputBoundary{

    private final EditNoteDataAccessInterface editNoteDataAccessInterface;
    private final CreateNoteDataAccessInterface createNoteDataAccessInterface;
    private final NoteFactory noteFactory;
    private final EditNoteOutputBoundary editNotePresenter;

    public SaveNoteInteractor(EditNoteDataAccessInterface editNoteDataAccessInterface,
                              CreateNoteDataAccessInterface createNoteDataAccessInterface,
                              NoteFactory noteFactory,
                              EditNoteOutputBoundary editNotePresenter) {
        this.editNoteDataAccessInterface = editNoteDataAccessInterface;
        this.createNoteDataAccessInterface = createNoteDataAccessInterface;
        this.noteFactory = noteFactory;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(SaveNoteInputData saveNoteInputData) throws IOException {
        // create a note entity using the InputData
        int noteID = saveNoteInputData.getNoteID();
        String noteText = saveNoteInputData.getNoteText();
        String noteTitle = saveNoteInputData.getNoteTitle();

        if (editNoteDataAccessInterface.existsByID(noteID)) { // note already exists
            System.out.println("Note exists.");

            editNoteDataAccessInterface.updateNote(noteID, noteText, noteTitle);
            System.out.println(editNoteDataAccessInterface.getCurrentText());

            EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteID, noteTitle, noteText);
            editNotePresenter.prepareNote(editNoteOutputData);

        }
    }
}