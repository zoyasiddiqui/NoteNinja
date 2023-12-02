package use_case.rename_note;

import use_case.save_note.SaveNoteInputData;

import java.io.IOException;

public interface RenameNoteInputBoundary {
    void execute(SaveNoteInputData saveNoteInputData) throws IOException;
}

