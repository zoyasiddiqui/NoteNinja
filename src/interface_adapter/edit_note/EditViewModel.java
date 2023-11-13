package interface_adapter.edit_note;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditViewModel extends ViewModel {
    public final String TITLE_LABEL = "Editing View";

    private EditState state = new EditState();

    public static final String LOGOUT_BUTTON_LABEL = "Save";
    private String noteTitle;

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public EditViewModel() {
        super("edit view");
    }
    // note that the constructor doesn't take in a Note object
    // instead we utilize setters and getters for the note title
    // will probably need to then have getters and setters for existing note data as well
    // consider whether we want to just take in a note object and if that aligns with CA engine.

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public EditState getState() {
        return this.state;
    }

    // firePropertyChanged() is what the EditPresenter will call a
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}