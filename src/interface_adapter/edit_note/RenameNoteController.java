package interface_adapter.edit_note;

import use_case.rename_note.RenameNoteInputBoundary;
import use_case.rename_note.RenameNoteInputData;

public class RenameNoteController {
    final RenameNoteInputBoundary renameInteractor;

    public RenameNoteController (RenameNoteInputBoundary renameInteractor) {
        this.renameInteractor = renameInteractor;
    }

    public void execute(String noteTitle) {
        RenameNoteInputData renameNoteInputData = new RenameNoteInputData(noteTitle);
    }
}
