package interface_adapter.edit_note;

import use_case.rename_note.RenameNoteInputBoundary;
import use_case.rename_note.RenameNoteInputData;
import use_case.save_note.SaveNoteInputData;

import java.io.IOException;

public class RenameNoteController {
    final RenameNoteInputBoundary renameInteractor;

    public RenameNoteController (RenameNoteInputBoundary renameInteractor) {
        this.renameInteractor = renameInteractor;
    }

    public void execute(int noteID, String noteTitle, String noteText) throws IOException {

        SaveNoteInputData saveNoteInputData = new SaveNoteInputData(noteTitle, noteText, noteID);
        renameInteractor.execute(saveNoteInputData);
    }
}
