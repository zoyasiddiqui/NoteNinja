package use_case.create_note;

import entity.Note.Note;
import entity.Note.NoteFactory;
import interface_adapter.edit_note.EditNoteState;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateNoteInteractor implements CreateNoteInputBoundary {

    final NoteFactory noteFactory;
    final CreateNoteDataAccessInterface noteDataAccessObject;
    final EditNoteOutputBoundary editNotePresenter;

    public CreateNoteInteractor(NoteFactory noteFactory, CreateNoteDataAccessInterface noteDataAccessObject, EditNoteOutputBoundary editNotePresenter) {
        this.noteFactory = noteFactory;
        this.noteDataAccessObject = noteDataAccessObject;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(CreateNoteInputData createNoteInputData) throws IOException {

        //doing three main things:
        //1. preparing any objects we'll need
        //2. using our DAO to do any persistence
        //3. preparing success view or fail view

        // get the appropriate noteID to set and set it on the state (not DAO)
        int noteID = noteDataAccessObject.getNoteCount() + 1;

        String noteText = createNoteInputData.getNoteText();
        String noteTitle = createNoteInputData.getNoteTitle();

        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteID, noteTitle, noteText);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}