// Package declaration indicating the location of the interface within the project structure
package use_case.edit_note;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the EditNoteInputBoundary interface
public interface EditNoteInputBoundary {

    // Declaration of the execute method without implementation details
    // This method is expected to be implemented by classes that implement this interface
    // It may throw IOException
    void execute() throws IOException;
}
