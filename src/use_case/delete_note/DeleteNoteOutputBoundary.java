package use_case.delete_note;



public interface DeleteNoteOutputBoundary {

    void prepareSuccessView(DeleteNoteOutputData response);

    void prepareFailView(String error);

}