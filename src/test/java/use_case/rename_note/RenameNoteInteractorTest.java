package use_case.rename_note;

import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.save_note.SaveNoteInputData;

import java.io.IOException;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class RenameNoteInteractorTest {

    @Test
    void testExecute() throws IOException {
        // Mock dependencies
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);
        EditNoteDataAccessInterface editNoteDataAccessObject = mock(EditNoteDataAccessInterface.class);

        // Create an instance of RenameNoteInteractor with the mocked dependencies
        RenameNoteInteractor renameNoteInteractor = new RenameNoteInteractor(editNotePresenter, editNoteDataAccessObject);

        // Define test input data
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData("New Title", "Note Text", 1);

        // Call the method under test
        renameNoteInteractor.execute(saveNoteInputData);

        // Verify that the updateNote method was called on the editNoteDataAccessObject with the correct arguments
        verify(editNoteDataAccessObject).updateNote(
                eq(1),               // Note ID
                eq("Note Text"),     // Note Text
                eq("New Title")      // New Title
        );

        // Verify that the editNotePresenter was notified with the new title
        verify(editNotePresenter).prepareTitleChange(any());
    }

    @Test
    void testExecuteIOException() throws IOException {
        // Mock dependencies
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);
        EditNoteDataAccessInterface editNoteDataAccessObject = mock(EditNoteDataAccessInterface.class);

        // Configure the mock to throw an IOException when updateNote is called
        doThrow(IOException.class).when(editNoteDataAccessObject).updateNote(anyInt(), anyString(), anyString());

        // Create an instance of RenameNoteInteractor with the mocked dependencies
        RenameNoteInteractor renameNoteInteractor = new RenameNoteInteractor(editNotePresenter, editNoteDataAccessObject);

        // Define test input data
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData("New Title", "Note Text", 1);

        // Call the method under test
        // Verify that IOException is propagated
        assertThrows(IOException.class, () -> renameNoteInteractor.execute(saveNoteInputData));

        // Verify that the editNotePresenter was not notified in case of exception
        verify(editNotePresenter, never()).prepareTitleChange(any());
    }
}
