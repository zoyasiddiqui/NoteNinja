package use_case.save_note;

import use_case.save_note.SaveNoteOutputData;

public interface SaveNoteOutputBoundary {
    void prepareSuccessView(SaveNoteOutputData usersDeleted);

    void prepareFailView(String errormessage);
}