// Package declaration indicating the location of the interface within the project structure
package use_case.edit_note;

// Import statement for the output data class from a different package
import use_case.rename_note.RenameNoteOutputData;

// Definition of the EditNoteOutputBoundary interface
public interface EditNoteOutputBoundary {

    // Declaration of methods without implementation details
    // These methods are expected to be implemented by classes that implement this interface

    // Prepare for displaying note content
    void prepareNote(EditNoteOutputData note);

    // Prepare for displaying title change
    void prepareTitleChange(RenameNoteOutputData title);

    // Prepare for navigating back to the menu
    void prepareBackMenu();
}
