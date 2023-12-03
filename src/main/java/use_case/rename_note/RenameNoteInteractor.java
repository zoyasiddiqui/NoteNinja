// Package declaration indicating the location of the class within the project structure
package use_case.rename_note;

// Import statements for classes from different packages
import interface_adapter.edit_note.EditNotePresenter;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import use_case.save_note.SaveNoteInputData;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the RenameNoteInteractor class implementing the RenameNoteInputBoundary interface
public class RenameNoteInteractor implements RenameNoteInputBoundary {

    // Instance variables to hold references to the output boundary presenter and data access interface
    final EditNoteOutputBoundary editNotePresenter;
    final EditNoteDataAccessInterface editNoteDataAccessObject;

    // Constructor for the RenameNoteInteractor class, taking two parameters
    public RenameNoteInteractor(EditNoteOutputBoundary editNotePresenter,
                                EditNoteDataAccessInterface editNoteDataAccessObject) {
        // Assign the provided references to the corresponding instance variables
        this.editNotePresenter = editNotePresenter;
        this.editNoteDataAccessObject = editNoteDataAccessObject;
    }

    // Implementation of the execute method defined in the RenameNoteInputBoundary interface
    @Override
    public void execute(SaveNoteInputData saveNoteInputData) throws IOException {
        // Extract note title from the input data
        String noteTitle = saveNoteInputData.getNoteTitle();

        // Create a RenameNoteOutputData object with the new note title
        RenameNoteOutputData renameNoteOutputData = new RenameNoteOutputData(noteTitle);

        // Update the note with the new title using the data access object
        editNoteDataAccessObject.updateNote(
                saveNoteInputData.getNoteID(),
                saveNoteInputData.getNoteText(),
                saveNoteInputData.getNoteTitle()
        );

        // Notify the presenter about the title change
        editNotePresenter.prepareTitleChange(renameNoteOutputData);
    }
}
