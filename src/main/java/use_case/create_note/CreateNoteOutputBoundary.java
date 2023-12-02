package use_case.create_note;
public interface CreateNoteOutputBoundary {

    void prepareSuccessView(CreateNoteOutputData response);

    void prepareFailView(String error);

}