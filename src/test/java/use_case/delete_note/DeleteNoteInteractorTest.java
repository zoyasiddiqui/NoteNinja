package use_case.delete_note;

import entity.Note.Note;
import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import static org.mockito.Mockito.*;

class DeleteNoteInteractorTest {

    @Test
    void execute_NoteFound_DeletesNoteAndPreparesBackMenu() throws Exception {
        // Arrange: Mock dependencies
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);
        DeleteNoteDataAccessInterface deleteNoteDataAccessInterface = mock(DeleteNoteDataAccessInterface.class,
                withSettings().extraInterfaces(EditNoteDataAccessInterface.class));
        int noteId = 123;

        // Mock behavior: Return a mock Note when getNoteById is called
        Note mockNote = mock(Note.class);
        when(((EditNoteDataAccessInterface) deleteNoteDataAccessInterface).getNoteById(noteId)).thenReturn(mockNote);

        // Act
        DeleteNoteInteractor deleteNoteInteractor = new DeleteNoteInteractor(editNotePresenter, deleteNoteDataAccessInterface);
        deleteNoteInteractor.execute(noteId);

        // Assert: Verify that delete method is called and prepareBackMenu is called
        verify(deleteNoteDataAccessInterface).delete(mockNote);
        verify(editNotePresenter).prepareBackMenu();
    }

    @Test
    void execute_NoteNotFound_PrepareBackMenu() throws Exception {
        // Arrange: Mock dependencies
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);
        DeleteNoteDataAccessInterface deleteNoteDataAccessInterface = mock(DeleteNoteDataAccessInterface.class,
                withSettings().extraInterfaces(EditNoteDataAccessInterface.class));
        int noteId = 123;

        // Mock behavior: Return null when getNoteById is called
        when(((EditNoteDataAccessInterface) deleteNoteDataAccessInterface).getNoteById(noteId)).thenReturn(null);

        // Act
        DeleteNoteInteractor deleteNoteInteractor = new DeleteNoteInteractor(editNotePresenter, deleteNoteDataAccessInterface);
        deleteNoteInteractor.execute(noteId);

        // Assert: Verify that prepareBackMenu is called
        verify(editNotePresenter).prepareBackMenu();
        // Verify that delete method is not called since note is null
        verify(deleteNoteDataAccessInterface, never()).delete(any());
    }
}
