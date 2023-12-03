package use_case.edit_note;

import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class EditNoteInteractorTest {

    @Test
    void testExecute_ExistingNote() throws IOException {
        // Mock dependencies
        EditNoteDataAccessInterface noteDataAccessObject = mock(EditNoteDataAccessInterface.class);
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);

        // Create an instance of EditNoteInteractor with the mocked dependencies
        EditNoteInteractor editNoteInteractor = new EditNoteInteractor(noteDataAccessObject, editNotePresenter);

        // Create a sample EditNoteInputData
        EditNoteInputData editNoteInputData = new EditNoteInputData("Updated Title", "Updated Text", 1);

        // Stubbing the existsByID method to return true (simulating an existing note)
        when(noteDataAccessObject.existsByID(1)).thenReturn(true);

        // Call the method under test
        editNoteInteractor.execute(editNoteInputData);

        // Verify that the updateNote method was called with the correct arguments
        verify(noteDataAccessObject).updateNote(1, "Updated Text", "Updated Title");
    }

    @Test
    void testExecute_NonExistingNote() throws IOException {
        // Mock dependencies
        EditNoteDataAccessInterface noteDataAccessObject = mock(EditNoteDataAccessInterface.class);
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);

        // Create an instance of EditNoteInteractor with the mocked dependencies
        EditNoteInteractor editNoteInteractor = new EditNoteInteractor(noteDataAccessObject, editNotePresenter);

        // Create a sample EditNoteInputData
        EditNoteInputData editNoteInputData = new EditNoteInputData("Updated Title", "Updated Text", 1);

        // Stubbing the existsByID method to return false (simulating a non-existing note)
        when(noteDataAccessObject.existsByID(1)).thenReturn(false);

        // Call the method under test
        editNoteInteractor.execute(editNoteInputData);

        // Verify that the updateNote method and prepareNote method were not called
        verify(noteDataAccessObject, never()).updateNote(anyInt(), anyString(), anyString());
        verify(editNotePresenter, never()).prepareNote(any(EditNoteOutputData.class));
    }
}
