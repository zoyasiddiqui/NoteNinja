package interface_adapter.create_note;

import interface_adapter.ViewModel;
import interface_adapter.search_notes.SearchState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateNoteViewModel extends ViewModel {

    public final String CREATE_BUTTON = "Create New Note";
    private SearchState state = new SearchState();

    public CreateNoteViewModel () {
        super("create note");
    }

    public void setState(SearchState state) {
        this.state = state;
    }

    public SearchState getState() {
        return this.state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}