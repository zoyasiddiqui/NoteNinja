package use_case.save_note;

import entity.Note.Note;
import entity.Note.NoteFactory;
import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

import static org.mockito.Mockito.*;

class SaveNoteInteractorTest {

    @Test
    void execute_NoteExists_UpdateNoteAndNotifyPresenter() throws Exception {
        // Arrange
        int existingNoteId = 123;
        String newNoteText = "Updated note text";
        String newNoteTitle = "Updated note title";

        SaveNoteInputData saveNoteInputData = new SaveNoteInputData(newNoteTitle, newNoteText, existingNoteId);
        EditNoteDataAccessInterface noteDataAccessObject = mock(EditNoteDataAccessInterface.class);
        NoteFactory noteFactory = mock(NoteFactory.class);
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);
        Note existingNote = mock(Note.class);

        // Mock behavior: Return true for existsByID, indicating the note exists
        when(noteDataAccessObject.existsByID(existingNoteId)).thenReturn(true);
        // Mock behavior: Return the existingNote when getNoteById is called
        when(noteDataAccessObject.getNoteById(existingNoteId)).thenReturn(existingNote);

        // Act
        SaveNoteInteractor saveNoteInteractor = new SaveNoteInteractor(noteDataAccessObject, noteFactory, editNotePresenter);
        saveNoteInteractor.execute(saveNoteInputData);

        // Assert: Verify that updateNote is called with the expected arguments
        verify(noteDataAccessObject).updateNote(eq(existingNoteId), eq(newNoteText), eq(newNoteTitle));
        verify(editNotePresenter).prepareNote(any());
    }


}
