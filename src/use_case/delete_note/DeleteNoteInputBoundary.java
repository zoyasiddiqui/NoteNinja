package use_case.delete_note;

import java.io.IOException;

public interface DeleteNoteInputBoundary {
    void execute(String noteId) throws IOException;
}