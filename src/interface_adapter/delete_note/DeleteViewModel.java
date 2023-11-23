package interface_adapter.delete_note;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteViewModel extends ViewModel {
    public final String TITLE_LABEL = "Deleting View";

    private DeleteState state = new DeleteState();

    public static final String DELETE_BUTTON_LABEL = "Delete";
    private String noteTitle;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DeleteViewModel() {
        super("delete view");
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
