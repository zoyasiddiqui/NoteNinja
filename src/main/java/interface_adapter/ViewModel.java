// Package declaration
package interface_adapter;

// Import statement for PropertyChangeListener
import java.beans.PropertyChangeListener;

// Abstract class declaration for ViewModel
public abstract class ViewModel {

    // Instance variable for storing the name of the view
    private String viewName;

    // Constructor for initializing the view name
    public ViewModel(String viewName) {
        this.viewName = viewName;
    }

    // Getter for retrieving the view name
    public String getViewName() {
        return this.viewName;
    }

    // Abstract method for triggering property change events
    public abstract void firePropertyChanged();

    // Abstract method for adding a property change listener
    public abstract void addPropertyChangeListener(PropertyChangeListener listener);
}
