// Package declaration
package interface_adapter.delete_note;

// Import statements for classes and interfaces
import use_case.delete_note.DeleteNoteInputBoundary;
import use_case.delete_note.DeleteNoteInputData;

import java.io.IOException;

// Class declaration for DeleteNoteController
public class DeleteNoteController {

    // Instance variable for the DeleteNoteInputBoundary
    final DeleteNoteInputBoundary deleteNoteInteractor;

    // Constructor for initializing the DeleteNoteController with a DeleteNoteInputBoundary
    public DeleteNoteController(DeleteNoteInputBoundary deleteNoteInteractor) {
        this.deleteNoteInteractor = deleteNoteInteractor;
    }

    // Method to execute the deletion of a note based on its ID
    public void execute(int noteId) throws IOException {
        this.deleteNoteInteractor.execute(noteId);
    }
}
