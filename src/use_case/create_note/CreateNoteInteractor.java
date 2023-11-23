package use_case.create_note;

import entity.Note.Note;
import entity.Note.NoteFactory;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateNoteInteractor implements CreateNoteInputBoundary{

    final NoteFactory noteFactory;
    final CreateNoteDataAccessInterface noteDataAccessObject;
    final EditNoteOutputBoundary editNotePresenter;

    public CreateNoteInteractor(NoteFactory noteFactory, CreateNoteDataAccessInterface noteDataAccessObject, EditNoteOutputBoundary editNotePresenter) {
        this.noteFactory = noteFactory;
        this.noteDataAccessObject = noteDataAccessObject;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(String name) throws IOException {
        String text = "";
        Note note = noteFactory.create(name, text);
        noteDataAccessObject.save(note);

        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(note, name, text);
        editNotePresenter.prepareNote(editNoteOutputData);
    }
}