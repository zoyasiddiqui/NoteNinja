package use_case.create_note;

import entity.Note.Note;
import entity.Note.NoteFactory;
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

        String noteText = "";
        String noteTitle = createNoteInputData.getNoteTitle();
        Note note = noteFactory.create(noteTitle, noteText);
        noteDataAccessObject.save(note);

        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(note, noteTitle, noteText);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}