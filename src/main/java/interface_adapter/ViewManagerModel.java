// Package declaration
package interface_adapter;

// Import statements for PropertyChangeListener and PropertyChangeSupport
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Class declaration for ViewManagerModel
public class ViewManagerModel {

    // Instance variable for storing the name of the active view
    private String activeViewName;

    // Instance variable for managing property change events
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Getter for retrieving the name of the active view
    public String getActiveView() {
        return activeViewName;
    }

    // Setter for updating the name of the active view
    public void setActiveView(String activeView) {
        this.activeViewName = activeView;
    }

    // Method for triggering property change events related to view changes
    public void firePropertyChanged() {
        support.firePropertyChange("view", null, this.activeViewName);
    }

    // Method for adding a property change listener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
