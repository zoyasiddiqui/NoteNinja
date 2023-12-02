package interface_adapter.create_note;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class CreateNoteViewModel extends ViewModel {
    public CreateNoteViewModel () {
        super("create note");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}