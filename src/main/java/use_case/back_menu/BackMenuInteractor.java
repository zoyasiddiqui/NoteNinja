package use_case.back_menu;

import use_case.edit_note.EditNoteOutputBoundary;

public class BackMenuInteractor implements BackMenuInputBoundary {
    final EditNoteOutputBoundary editNotePresenter;

    public BackMenuInteractor (EditNoteOutputBoundary editNotePresenter) {
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute() {
        editNotePresenter.prepareBackMenu();
    }
}

