// Package declaration indicating the location of the interface within the project structure
package use_case.delete_note;

// Import statements for classes from different packages
import entity.Note.Note;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the DeleteNoteDataAccessInterface interface
public interface DeleteNoteDataAccessInterface {

    // Declaration of the delete method without implementation details
    // This method is expected to be implemented by classes that implement this interface
    // It takes a Note parameter and may throw IOException
    void delete(Note note) throws IOException;
}
