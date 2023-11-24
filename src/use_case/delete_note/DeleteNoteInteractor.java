package use_case.delete_note;

import entity.Note.Note;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;
import java.util.List;

public class DeleteNoteInteractor implements DeleteNoteInputBoundary {
    private final EditNoteDataAccessInterface editNoteDataAccessInterface;
    private final EditNoteOutputBoundary editNotePresenter;
    private List<Note> notes;

    public DeleteNoteInteractor(EditNoteDataAccessInterface editNoteDataAccessInterface,
                                EditNoteOutputBoundary editNotePresenter, List<Note> notes) {
        this.editNoteDataAccessInterface = editNoteDataAccessInterface;
        this.editNotePresenter = editNotePresenter;
        this.notes = notes;
    }

    public void execute(String noteId) throws IOException {
        // Assuming you have a method to retrieve a Note object by its ID
        Note note = editNoteDataAccessInterface.getNoteById(notes, noteId);

        // Call the delete method from the data access object
        editNoteDataAccessInterface.delete(note);

        // You may want to notify the presenter or handle the result in some way
        // For example:
        editNotePresenter.noteDeletedSuccessfully(); // Assuming you have a method like this in your presenter
    }
}
