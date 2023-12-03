// Package declaration indicating the location of the interface within the project structure
package use_case.edit_note;

// Import statements for classes from different packages
import entity.Note.Note;

// Import statement for handling IOException
import java.io.IOException;
import java.util.List;

// Definition of the EditNoteDataAccessInterface interface
public interface EditNoteDataAccessInterface {

    // Declaration of methods without implementation details
    // These methods are expected to be implemented by classes that implement this interface

    // Get a Note by its ID
    Note getNoteById(int noteId);

    // Check if a Note with a given ID exists
    boolean existsByID(int noteID);

    // Update the content of a Note by its ID
    void updateNote(int noteID, String noteText, String noteTitle) throws IOException;

    // Get the current text
    String getCurrentText();

    // Set the current text
    void setCurrentText(String text);

}
