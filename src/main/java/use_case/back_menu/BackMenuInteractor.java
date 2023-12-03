// Package declaration indicating the location of the class within the project structure
package use_case.back_menu;

// Import statement for a class in a different package
import use_case.edit_note.EditNoteOutputBoundary;

// Definition of the BackMenuInteractor class implementing the BackMenuInputBoundary interface
public class BackMenuInteractor implements BackMenuInputBoundary {

    // Instance variable to hold the reference to the EditNoteOutputBoundary presenter
    final EditNoteOutputBoundary editNotePresenter;

    // Constructor for the BackMenuInteractor class, taking an EditNoteOutputBoundary as a parameter
    public BackMenuInteractor (EditNoteOutputBoundary editNotePresenter) {
        // Assign the provided EditNoteOutputBoundary reference to the instance variable
        this.editNotePresenter = editNotePresenter;
    }

    // Implementation of the execute method defined in the BackMenuInputBoundary interface
    @Override
    public void execute() {
        // Call the prepareBackMenu method on the EditNoteOutputBoundary presenter
        editNotePresenter.prepareBackMenu();
    }
}
