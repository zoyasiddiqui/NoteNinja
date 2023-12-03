// Package declaration indicating the location of the interface within the project structure
package use_case.create_note;

// Import statements for classes from different packages
import entity.Note.Note;

// Import statement for handling IOException
import java.io.IOException;

// Definition of the CreateNoteDataAccessInterface interface
public interface CreateNoteDataAccessInterface {

    // Declaration of the create method without implementation details
    // This method is expected to be implemented by classes that implement this interface
    // It takes a Note parameter and may throw IOException
    void create(Note note) throws IOException;

    // Declaration of the getNoteCount method without implementation details
    // This method is expected to be implemented by classes that implement this interface
    // It returns an integer representing the count of notes
    int getNoteCount();
}
