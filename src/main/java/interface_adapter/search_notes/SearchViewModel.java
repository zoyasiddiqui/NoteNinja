package interface_adapter.search_notes;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {
    public final String CREATE_BUTTON = "Create New Note";
    private SearchState state = new SearchState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public SearchViewModel() {
        super("search notes");
    }

    public SearchState getState() {
        return state;
    }

    public void setState(SearchState state) {
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}