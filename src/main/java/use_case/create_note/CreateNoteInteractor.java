// Package declaration indicating the location of the class within the project structure
package use_case.create_note;

// Import statements for classes from different packages
import entity.Note.Note;
import entity.Note.NoteFactory;
import interface_adapter.edit_note.EditNoteState;
import use_case.search_notes.SearchOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the CreateNoteInteractor class implementing the CreateNoteInputBoundary interface
public class CreateNoteInteractor implements CreateNoteInputBoundary {

    // Instance variables to hold references to the note factory, data access object, and output boundary presenter
    final NoteFactory noteFactory;
    final CreateNoteDataAccessInterface noteDataAccessObject;
    final SearchOutputBoundary searchNotePresenter;

    // Constructor for the CreateNoteInteractor class, taking three parameters
    public CreateNoteInteractor(NoteFactory noteFactory, CreateNoteDataAccessInterface noteDataAccessObject, SearchOutputBoundary searchNotePresenter) {
        // Assign the provided references to the corresponding instance variables
        this.noteFactory = noteFactory;
        this.noteDataAccessObject = noteDataAccessObject;
        this.searchNotePresenter = searchNotePresenter;
    }

    // Implementation of the execute method defined in the CreateNoteInputBoundary interface
    @Override
    public void execute(CreateNoteInputData createNoteInputData) throws IOException {

        // Doing three main things:
        // 1. Preparing any objects we'll need
        // 2. Using our DAO to do any persistence
        // 3. Preparing success view or fail view

        // Get the appropriate noteID to set and set it on the state (not DAO)
        int noteID = noteDataAccessObject.getNoteCount() + 1;

        // Extract data from the input object
        String noteText = createNoteInputData.getNoteText();
        String noteTitle = createNoteInputData.getNoteTitle();

        // Prepare output data and notify the presenter
        EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteID, noteTitle, noteText);
        searchNotePresenter.prepareNewNote(editNoteOutputData);
    }
}
