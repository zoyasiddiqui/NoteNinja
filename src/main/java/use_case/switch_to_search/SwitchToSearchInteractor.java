package use_case.switch_to_search;

import use_case.edit_note.EditNoteOutputBoundary;

public class SwitchToSearchInteractor implements SwitchToSearchInputBoundary{

    private final EditNoteOutputBoundary editNotePresenter;

    public SwitchToSearchInteractor(EditNoteOutputBoundary editNotePresenter) {
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute() {
        editNotePresenter.prepareSearchView();
    }
}
