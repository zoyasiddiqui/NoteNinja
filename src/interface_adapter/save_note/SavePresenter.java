package interface_adapter.save_note;

import use_case.save_note.SaveNoteOutputBoundary;
import use_case.save_note.SaveNoteOutputData;

public class SavePresenter implements SaveNoteOutputBoundary{

    @Override
    public void prepareSuccessView(SaveNoteOutputData usersDeleted) {

    }

    @Override
    public void prepareFailView(String errormessage) {

    }
}