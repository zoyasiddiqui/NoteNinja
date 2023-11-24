package interface_adapter.delete_note;

import use_case.delete_note.DeleteNoteInputBoundary;
import use_case.delete_note.DeleteNoteInputData;

import java.io.IOException;

public class DeleteNoteController {
    private final DeleteNoteInputBoundary deleteNoteInteractor;

    public DeleteNoteController(DeleteNoteInputBoundary deleteNoteInteractor) {
        this.deleteNoteInteractor = deleteNoteInteractor;
    }

    public void execute(String noteId) throws IOException {
        DeleteNoteInputData deleteNoteInputData = new DeleteNoteInputData(noteId);
        this.deleteNoteInteractor.execute(String.valueOf(deleteNoteInputData));
    }
}
