package interface_adapter.edit_note;

import use_case.edit_note.EditNoteInputBoundary;
import use_case.edit_note.EditNoteOutputData;

public class EditNoteController {
    private final EditNoteInputBoundary editNoteInteractor;

    public EditNoteController (EditNoteInputBoundary editNoteInteractor) {
        this.editNoteInteractor = editNoteInteractor;
    }

    public void execute (String noteText) {
        // EditNoteOutputData editNoteOutputData = new EditNoteOutputData(noteText);
        // TODO: uncomment the above and finish execute() once we decide on the EditNoteOutputData format
    }

}