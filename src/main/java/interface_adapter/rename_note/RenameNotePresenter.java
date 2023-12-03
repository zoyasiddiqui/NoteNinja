package interface_adapter.rename_note;

import interface_adapter.edit_note.EditNoteState;
import interface_adapter.edit_note.EditNoteViewModel;
import use_case.rename_note.RenameNoteOutputBoundary;
import use_case.rename_note.RenameNoteOutputData;

public class RenameNotePresenter implements RenameNoteOutputBoundary {

    private final EditNoteViewModel editNoteViewModel;

    public RenameNotePresenter(EditNoteViewModel editNoteViewModel) {
        this.editNoteViewModel = editNoteViewModel;
    }

    @Override
    public void prepareNewTitle(RenameNoteOutputData title) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteTitle(title.getTitle());
        this.editNoteViewModel.setState(noteState);
        this.editNoteViewModel.firePropertyChanged();
    }
}
