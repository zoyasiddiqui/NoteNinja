// Package declaration
package interface_adapter.edit_note;

// Import statements for various classes and interfaces
import use_case.save_note.SaveNoteInputBoundary;
import use_case.save_note.SaveNoteInputData;
import use_case.save_note.SaveNoteInteractor;

import java.io.IOException;

// Class declaration for SaveController
public class EditController {
    // Instance variable for SaveNoteInputBoundary
    final SaveNoteInputBoundary saveNoteInteractor;

    // Constructor for SaveController
    public EditController(SaveNoteInteractor saveNoteInteractor) {
        this.saveNoteInteractor = saveNoteInteractor;
    }

    // Method to execute saving of a note
    public void execute(String noteTitle, String noteText, int noteID) throws IOException {
        // Create SaveNoteInputData using provided parameters
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData(noteTitle, noteText, noteID);
        // Execute the save operation using SaveNoteInputBoundary
        this.saveNoteInteractor.execute(saveNoteInputData);
    }
}
