package use_case.delete_note;

import use_case.create_note.DeleteNoteOutputData;

public interface DeleteNoteOutputBoundary {

    void prepareSuccessView(DeleteNoteOutputData response);

    void prepareFailView(String error);

}