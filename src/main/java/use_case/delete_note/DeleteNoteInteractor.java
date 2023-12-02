package use_case.delete_note;

import entity.Note.Note;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;

public class DeleteNoteInteractor implements DeleteNoteInputBoundary {
    private final DeleteNoteDataAccessInterface deleteNoteDataAccessInterface;
    private final EditNoteOutputBoundary editNotePresenter;

    public DeleteNoteInteractor(EditNoteOutputBoundary editNotePresenter,
                                DeleteNoteDataAccessInterface deleteNoteDataAccessInterface) {

        this.deleteNoteDataAccessInterface = deleteNoteDataAccessInterface;
        this.editNotePresenter = editNotePresenter;
    }

    public void execute(int noteId) throws IOException {

        // note here that we cast deleteNoteDataAccessInterface to EditNoteDataAccessInterface because
        // it is one EditNoteDataAccessObject which implements several interfaces.
        Note note = ((EditNoteDataAccessInterface) deleteNoteDataAccessInterface).getNoteById(noteId);
        System.out.println("Looking for "+noteId+" and found "+note.getID());

        // Call the delete method from the data access object

        deleteNoteDataAccessInterface.delete(note);

        // You may want to notify the presenter or handle the result in some way
        // For example:
        editNotePresenter.prepareBackMenu(); // Assuming you have a method like this in your presenter
    }
}
