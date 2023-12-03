// Package declaration
package interface_adapter.edit_note;

// Import statement for PropertyChangeListener and PropertyChangeSupport
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Class declaration for EditNoteViewModel extending ViewModel
public class EditNoteViewModel extends ViewModel {

    // Constant strings for labels and view name
    public static final String DELETE_NOTE_LABEL = "Delete";
    public static final String BACK_MENU_LABEL = "Back";
    public static final String AI_SNIPPET_LABEL = "Create AI Snippet!";
    public static final String DEFAULT_NOTE_TITLE = "Untitled";
    public static final String CODE_SNIPPET_LABEL = "Create Code Snippet!";
    public static final String SAVE_NOTE_LABEL = "Save";

    // Instance variables for state, note title, and view name
    private EditNoteState state = new EditNoteState();
    private String noteTitle;
    private final String viewName = "editing";

    // PropertyChangeSupport for handling property change events
    final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Constructor for EditNoteViewModel
    public EditNoteViewModel() {
        super("edit view");
    }

    // Setter method for note title
    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    // Getter method for state
    public EditNoteState getState() {
        return this.state;
    }

    // Method to fire property change events
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    // Method to add property change listener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    // Setter method for setting state
    public void setState(EditNoteState noteState) {
        this.state = noteState;
    }

    // Getter method for view name
    public String getViewName() {
        return this.viewName;
    }
}
