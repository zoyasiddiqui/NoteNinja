// Package declaration indicating the location of the class within the project structure
package use_case.save_note;

// Import statements for handling IOException and other classes/interfaces
import entity.Note.Note;
import entity.Note.NoteFactory;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

// Definition of the SaveNoteInteractor class implementing SaveNoteInputBoundary interface
public class SaveNoteInteractor implements SaveNoteInputBoundary {

    // Private instance variables for dependencies
    private final EditNoteDataAccessInterface noteDataAccessObject;
    private final NoteFactory noteFactory;
    private final EditNoteOutputBoundary editNotePresenter;

    // Constructor for initializing the SaveNoteInteractor object with dependencies
    public SaveNoteInteractor(EditNoteDataAccessInterface noteDataAccessObject,
                              NoteFactory noteFactory,
                              EditNoteOutputBoundary editNotePresenter) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.noteFactory = noteFactory;
        this.editNotePresenter = editNotePresenter;
    }

    // Implementation of the execute method from the SaveNoteInputBoundary interface
    @Override
    public void execute(SaveNoteInputData saveNoteInputData) throws IOException {
        int noteID = saveNoteInputData.getNoteID();

        // Create a note entity using the InputData if the note does not exist
        String noteText = saveNoteInputData.getNoteText();
        String noteTitle = saveNoteInputData.getNoteTitle();

        if (noteDataAccessObject.existsByID(noteID)) { // Note already exists
            System.out.println("Note exists.");

            noteDataAccessObject.updateNote(noteID, noteText, noteTitle);
            System.out.println(noteDataAccessObject.getCurrentText());

            // Prepare the output data and notify the presenter
            EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteID, noteTitle, noteText);
            editNotePresenter.prepareNote(editNoteOutputData);
        } else {
            // Create a new note using the factory and save it through the CreateNoteDataAccessInterface
            Note note = noteFactory.create(noteTitle, noteText, noteID);
            ((CreateNoteDataAccessInterface) noteDataAccessObject).create(note);
        }
    }
}
