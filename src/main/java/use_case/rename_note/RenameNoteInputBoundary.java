package use_case.rename_note;

import java.io.IOException;

public interface RenameNoteInputBoundary {
    void execute(RenameNoteInputData renameNoteInputData) throws IOException;
}
