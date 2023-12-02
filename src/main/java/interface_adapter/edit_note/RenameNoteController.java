// Package declaration
package interface_adapter.edit_note;

// Import statements for various classes and interfaces
import use_case.rename_note.RenameNoteInputBoundary;
import use_case.rename_note.RenameNoteInputData;
import use_case.save_note.SaveNoteInputData;

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
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData(noteTitle, noteText, noteID);
        // Execute the rename operation using RenameNoteInputBoundary
        renameInteractor.execute(saveNoteInputData);
    }
}
