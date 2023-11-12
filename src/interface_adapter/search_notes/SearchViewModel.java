package interface_adapter.search_notes;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {

    public final String CREATE_BUTTON = "Create Note";

    private final SearchState state = new SearchState();

    public SearchViewModel() {
        super("search notes");
    }

    public SearchState getState() {
        return state;
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}