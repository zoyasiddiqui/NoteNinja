// Package declaration
package interface_adapter.rename_note;

// Import statements for various classes and interfaces
import use_case.edit_note.EditNoteInputData;
import use_case.rename_note.RenameNoteInputBoundary;
import use_case.rename_note.RenameNoteInputData;

import java.io.IOException;

// Class declaration for RenameNoteController
public class RenameNoteController {
    // Instance variable for RenameNoteInputBoundary
    final RenameNoteInputBoundary renameInteractor;

    // Constructor for RenameNoteController
    public RenameNoteController (RenameNoteInputBoundary renameInteractor) {
        this.renameInteractor = renameInteractor;
    }

    // Method to execute renaming of a note
    public void execute(int noteID, String noteTitle, String noteText) throws IOException {
        // Create SaveNoteInputData using provided parameters
        EditNoteInputData editNoteInputData = new EditNoteInputData(noteTitle, noteText, noteID);
        // Execute the rename operation using RenameNoteInputBoundary
        renameInteractor.execute(editNoteInputData);
    }
}
