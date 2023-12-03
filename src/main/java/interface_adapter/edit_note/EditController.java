// Package declaration
package interface_adapter.edit_note;

import use_case.edit_note.EditNoteInputBoundary;
import use_case.edit_note.EditNoteInputData;
import use_case.edit_note.EditNoteInteractor;

import java.io.IOException;

// Class declaration for SaveController
public class EditController {
    // Instance variable for SaveNoteInputBoundary
    final EditNoteInputBoundary editNoteInteractor;

    // Constructor for SaveController
    public EditController(EditNoteInputBoundary editNoteInteractor) {
        this.editNoteInteractor = editNoteInteractor;
    }

    // Method to execute saving of a note
    public void execute(String noteTitle, String noteText, int noteID) throws IOException {
        // Create SaveNoteInputData using provided parameters
        EditNoteInputData saveNoteInputData = new EditNoteInputData(noteTitle, noteText, noteID);
        // Execute the save operation using SaveNoteInputBoundary
        this.editNoteInteractor.execute(saveNoteInputData);
    }
}
