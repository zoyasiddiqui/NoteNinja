// Package declaration
package interface_adapter.back_menu;

// Import statement for the BackMenuInputBoundary interface
import use_case.back_menu.BackMenuInputBoundary;

// Class declaration for BackMenuController
public class BackMenuController {

    // Instance variable for the associated BackMenuInputBoundary
    final BackMenuInputBoundary backMenuInteractor;

    // Constructor for initializing the BackMenuController with a BackMenuInputBoundary
    public BackMenuController (BackMenuInputBoundary backMenuInteractor) {
        this.backMenuInteractor = backMenuInteractor;
    }

    // Method to execute the back menu action using the associated interactor
    public void execute() {
        this.backMenuInteractor.execute();
    }
}
