package interface_adapter.edit_note;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EditNoteViewModel extends ViewModel {

    public static final String DELETE_NOTE_LABEL = "Delete";
    public static final String BACK_MENU_LABEL = "Back";
    public static final String DEFAULT_NOTE_TITLE = "Untitled";
    private EditNoteState state = new EditNoteState();

    public static final String SAVE_NOTE_LABEL = "Save";
    private String noteTitle;
    private final String viewName = "editing";

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public EditNoteViewModel() {
        super("edit view");
    }
    // note that the constructor doesn't take in a Note object
    // instead we utilize setters and getters for the note title
    // will probably need to then have getters and setters for existing note data as well
    // consider whether we want to just take in a note object and if that aligns with CA engine.

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public EditNoteState getState() {
        return this.state;
    }

    // firePropertyChanged() is what the EditPresenter will call a
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setState(EditNoteState noteState) {
        this.state = noteState;
    }

    public String getViewName() {
        return this.viewName;
    }
}