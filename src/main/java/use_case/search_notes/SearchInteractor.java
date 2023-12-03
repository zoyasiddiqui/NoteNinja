// Package declaration indicating the location of the class within the project structure
package use_case.search_notes;

// Import statements for handling IOException, Note entity, and output boundaries
import entity.Note.Note;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;

import java.io.IOException;

// Definition of the SearchInteractor class implementing the SearchInputBoundary interface
public class SearchInteractor implements SearchInputBoundary {

    // Instance variables for the searchNotesAccessInterface and editNotePresenter
    final SearchNotesAccessInterface searchNotesAccessInterface;
    final EditNoteOutputBoundary editNotePresenter;

    // Constructor for initializing the SearchInteractor with dependencies
    public SearchInteractor(SearchNotesAccessInterface searchNotesAccessInterface,
                            EditNoteOutputBoundary editNotePresenter) {
        this.searchNotesAccessInterface = searchNotesAccessInterface;
        this.editNotePresenter = editNotePresenter;
    }

    // Implementation of the execute method from the SearchInputBoundary interface
    @Override
    public void execute(String search) throws IOException {
        // Find a Note using the searchNotesAccessInterface
        Note note = this.searchNotesAccessInterface.findByTitle(search);

        // Check if a matching Note is found
        if (note != null) {
            // Prepare output data and notify the presenter
            EditNoteOutputData editNoteOutputData = new EditNoteOutputData(note.getID(), note.getName(), note.getText());
            editNotePresenter.prepareNote(editNoteOutputData);
        }
    }
}
