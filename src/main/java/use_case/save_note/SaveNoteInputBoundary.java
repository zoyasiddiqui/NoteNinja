package use_case.save_note;

import java.io.IOException;

public interface SaveNoteInputBoundary {
    void execute(SaveNoteInputData saveNoteInputData) throws IOException;
}