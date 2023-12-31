// Package declaration indicating the location of the class within the project structure
package use_case.delete_note;

// Import statements for classes from different packages
import entity.Note.Note;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the DeleteNoteInteractor class implementing the DeleteNoteInputBoundary interface
public class DeleteNoteInteractor implements DeleteNoteInputBoundary {

    // Instance variables to hold references to the data access interface and output boundary presenter
    private final DeleteNoteDataAccessInterface deleteNoteDataAccessInterface;
    private final EditNoteOutputBoundary editNotePresenter;

    // Constructor for the DeleteNoteInteractor class, taking two parameters
    public DeleteNoteInteractor(EditNoteOutputBoundary editNotePresenter,
                                DeleteNoteDataAccessInterface deleteNoteDataAccessInterface) {
        // Assign the provided references to the corresponding instance variables
        this.deleteNoteDataAccessInterface = deleteNoteDataAccessInterface;
        this.editNotePresenter = editNotePresenter;
    }

    // Implementation of the execute method defined in the DeleteNoteInputBoundary interface
    @Override
    public void execute(int noteId) throws IOException {
        System.out.println(noteId);

        // Note here that we cast deleteNoteDataAccessInterface to EditNoteDataAccessInterface because
        // it is one EditNoteDataAccessObject which implements several interfaces.
        Note note = ((EditNoteDataAccessInterface) deleteNoteDataAccessInterface).getNoteById(noteId);

        if (note == null) {
            editNotePresenter.prepareBackMenu();
        } else {
            System.out.println("Looking for " + noteId + " and found " + note.getID());

            // Call the delete method from the data access object
            deleteNoteDataAccessInterface.delete(note);
            editNotePresenter.prepareBackMenu();
        }

    }
}
