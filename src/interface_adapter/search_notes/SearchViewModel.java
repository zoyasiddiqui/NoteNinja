package interface_adapter.search_notes;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class SearchViewModel extends ViewModel {

    public final String CREATE_BUTTON = "Create Button";

    private final SearchState state = new SearchState();

    //TODO: modify constructor as needed
    public SearchViewModel(String viewName) {
        super(viewName);
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