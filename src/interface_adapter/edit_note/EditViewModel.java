package interface_adapter.edit_note;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditViewModel extends ViewModel {
    public final String TITLE_LABEL = "Editing View";

    private EditState state = new EditState();

    public static final String LOGOUT_BUTTON_LABEL = "Save";
    private String noteTitle;

    //TODO: modify constructor as needed
    public EditViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}