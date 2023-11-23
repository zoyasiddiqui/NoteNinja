package use_case.save_note;

import use_case.save_note.SaveNoteOutputData;

public interface SaveNoteOutputBoundary {
    void prepareSuccessView();

    void prepareFailView(String errormessage);
}