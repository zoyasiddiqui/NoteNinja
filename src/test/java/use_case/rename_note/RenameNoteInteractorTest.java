package use_case.rename_note;

import interface_adapter.edit_note.EditNotePresenter;
import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.save_note.SaveNoteInputData;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RenameNoteInteractorTest {

    @Test
    void testExecute() throws IOException {
        // Mock dependencies
        EditNoteOutputBoundary editNotePresenter = mock(EditNotePresenter.class);
        EditNoteDataAccessInterface editNoteDataAccessObject = mock(EditNoteDataAccessInterface.class);

        // Create an instance of RenameNoteInteractor with the mock dependencies
        RenameNoteInteractor renameNoteInteractor = new RenameNoteInteractor(editNotePresenter, editNoteDataAccessObject);

        // Create sample input data
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData("New Note Title", "New Note Text", 1);

        // Perform the execute method
        renameNoteInteractor.execute(saveNoteInputData);

        // Verify that updateNote method was called with the correct arguments
        verify(editNoteDataAccessObject).updateNote(1, "New Note Text", "New Note Title");

        // Verify that prepareTitleChange method was called with the correct argument
        verify(editNotePresenter).prepareTitleChange(any());

    }

}