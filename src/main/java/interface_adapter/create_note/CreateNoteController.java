// Package declaration
package interface_adapter.create_note;

// Import statements for various classes and interfaces
import use_case.create_note.CreateNoteInputBoundary;
import use_case.create_note.CreateNoteInputData;

import java.io.IOException;

// Class declaration for CreateNoteController
public class CreateNoteController {
    // Private member variable to hold CreateNoteInputBoundary instance
    final CreateNoteInputBoundary createNoteInteractor;

    // Constructor to initialize CreateNoteController with CreateNoteInputBoundary
    public CreateNoteController(CreateNoteInputBoundary createNoteInteractor) {
        this.createNoteInteractor = createNoteInteractor;
    }

    // Method to execute the creation of a new note
    public void execute(String noteTitle, String noteText) throws IOException {
        // Create CreateNoteInputData instance with provided noteTitle and noteText
        CreateNoteInputData createNoteInputData = new CreateNoteInputData(noteTitle, noteText);
        // Execute the creation of the note using CreateNoteInteractor
        this.createNoteInteractor.execute(createNoteInputData);
    }
}
