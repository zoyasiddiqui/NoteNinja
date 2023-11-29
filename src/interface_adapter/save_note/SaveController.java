package interface_adapter.save_note;

import use_case.save_note.SaveNoteInputBoundary;
import use_case.save_note.SaveNoteInputData;
import use_case.save_note.SaveNoteInteractor;

import java.io.IOException;

public class SaveController {

    final SaveNoteInputBoundary saveNoteInteractor;

    public SaveController(SaveNoteInteractor saveNoteInteractor) {
        this.saveNoteInteractor = saveNoteInteractor;
    }

    public void execute(String noteTitle, String noteText, int noteID) throws IOException {
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData(noteTitle, noteText, noteID);
        this.saveNoteInteractor.execute(saveNoteInputData);

    }

}