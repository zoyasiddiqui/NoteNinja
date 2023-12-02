// Package declaration
package interface_adapter.create_note;

// Import statements for classes and interfaces
import interface_adapter.ViewModel;
import interface_adapter.search_notes.SearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Class declaration for CreateNoteViewModel extending ViewModel
public class CreateNoteViewModel extends ViewModel {

    // Constant for the create button text
    public final String CREATE_BUTTON = "Create New Note";

    // Instance variable to hold the state of the search
    private SearchState state = new SearchState();

    // Constructor
    public CreateNoteViewModel() {
        super("create note");
    }

    // Setter method for setting the state
    public void setState(SearchState state) {
        this.state = state;
    }

    // Getter method for retrieving the state
    public SearchState getState() {
        return this.state;
    }

    // PropertyChangeSupport instance for handling property change events
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Overridden method to notify listeners about property changes
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    // Overridden method to add a property change listener
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
