package use_case.rename_note;

import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteInputData;
import use_case.rename_note.RenameNoteOutputBoundary;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class RenameNoteInteractorTest {

    @Test
    void testExecute() throws IOException {
        // Mock dependencies
        RenameNoteOutputBoundary renameNotePresenter = mock(RenameNoteOutputBoundary.class);
        EditNoteDataAccessInterface editNoteDataAccessObject = mock(EditNoteDataAccessInterface.class);

        // Create an instance of RenameNoteInteractor with the mocked dependencies
        RenameNoteInteractor renameNoteInteractor = new RenameNoteInteractor(renameNotePresenter, editNoteDataAccessObject);

        // Define test input data
        EditNoteInputData editNoteInputData = new EditNoteInputData("New Title", "Note Text", 1);

        // Call the method under test
        renameNoteInteractor.execute(editNoteInputData);

        // Verify that the updateNote method was called on the editNoteDataAccessObject with the correct arguments
        verify(editNoteDataAccessObject).updateNote(
                eq(1),           // Note ID
                eq("Note Text"), // Note Text
                eq("New Title")  // New Title
        );

        // Verify that the renameNotePresenter was notified with the new title
        verify(renameNotePresenter).prepareNewTitle(any());
    }
}
