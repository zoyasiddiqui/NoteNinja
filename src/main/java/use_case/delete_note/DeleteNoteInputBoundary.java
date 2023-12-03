// Package declaration indicating the location of the interface within the project structure
package use_case.delete_note;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the DeleteNoteInputBoundary interface
public interface DeleteNoteInputBoundary {

    // Declaration of the execute method without implementation details
    // This method is expected to be implemented by classes that implement this interface
    // It takes an integer noteId parameter and may throw IOException
    void execute(int noteId) throws IOException;
}
