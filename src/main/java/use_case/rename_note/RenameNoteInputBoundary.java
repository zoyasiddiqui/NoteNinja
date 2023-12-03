// Package declaration indicating the location of the interface within the project structure
package use_case.rename_note;

// Import statements for classes from different packages
import use_case.save_note.SaveNoteInputData;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the RenameNoteInputBoundary interface
public interface RenameNoteInputBoundary {

    // Declaration of the execute method without implementation details
    // This method is expected to be implemented by classes that implement this interface
    // It takes a SaveNoteInputData parameter and may throw IOException
    void execute(SaveNoteInputData saveNoteInputData) throws IOException;
}
