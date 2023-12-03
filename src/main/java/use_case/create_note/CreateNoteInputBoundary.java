// Package declaration indicating the location of the interface within the project structure
package use_case.create_note;

// Import statements for classes from different packages
import entity.Note.Note;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the CreateNoteInputBoundary interface
public interface CreateNoteInputBoundary {

    // Declaration of the execute method without implementation details
    // This method is expected to be implemented by classes that implement this interface
    // It takes a CreateNoteInputData parameter and may throw IOException
    void execute(CreateNoteInputData createNoteInputData) throws IOException;
}
