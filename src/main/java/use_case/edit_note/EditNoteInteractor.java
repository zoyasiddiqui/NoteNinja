// Package declaration indicating the location of the class within the project structure
package use_case.edit_note;

// Import statements for handling IOException and other classes/interfaces
import entity.Note.Note;
import entity.Note.NoteFactory;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

// Definition of the SaveNoteInteractor class implementing SaveNoteInputBoundary interface
public class EditNoteInteractor implements EditNoteInputBoundary {

    // Private instance variables for dependencies
    private final EditNoteDataAccessInterface noteDataAccessObject;
    private final NoteFactory noteFactory;
    private final EditNoteOutputBoundary editNotePresenter;

    // Constructor for initializing the SaveNoteInteractor object with dependencies
    public EditNoteInteractor(EditNoteDataAccessInterface noteDataAccessObject,
                              NoteFactory noteFactory,
                              EditNoteOutputBoundary editNotePresenter) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.noteFactory = noteFactory;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(EditNoteInputData editNoteInputData) throws IOException {
        int noteID = editNoteInputData.getNoteID();
        String noteText = editNoteInputData.getNoteText();
        String noteTitle = editNoteInputData.getNoteTitle();

        if (noteDataAccessObject.existsByID(noteID)) {
            noteDataAccessObject.updateNote(noteID, noteText, noteTitle);

            EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteID, noteTitle, noteText);
            editNotePresenter.prepareNote(editNoteOutputData);
        }
    }
}
