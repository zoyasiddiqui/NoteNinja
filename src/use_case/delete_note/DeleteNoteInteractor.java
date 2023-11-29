package use_case.delete_note;

import entity.Note.Note;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;
import java.util.List;

public class DeleteNoteInteractor implements DeleteNoteInputBoundary {
    private final EditNoteDataAccessInterface editNoteDataAccessInterface;
    private final DeleteNoteDataAccessInterface deleteNoteDataAccessInterface;
    private final EditNoteOutputBoundary editNotePresenter;

    public DeleteNoteInteractor(EditNoteDataAccessInterface editNoteDataAccessInterface,
                                EditNoteOutputBoundary editNotePresenter,
                                DeleteNoteDataAccessInterface deleteNoteDataAccessInterface) {
        this.editNoteDataAccessInterface = editNoteDataAccessInterface;
        this.deleteNoteDataAccessInterface = deleteNoteDataAccessInterface;
        this.editNotePresenter = editNotePresenter;
    }

    public void execute(int noteId) throws IOException {
        // Assuming you have a method to retrieve a Note object by its ID
        Note note = editNoteDataAccessInterface.getNoteById(noteId);

        // Call the delete method from the data access object
        deleteNoteDataAccessInterface.delete(note);

        // You may want to notify the presenter or handle the result in some way
        // For example:
        editNotePresenter.noteDeletedSuccessfully(); // Assuming you have a method like this in your presenter
    }
}
