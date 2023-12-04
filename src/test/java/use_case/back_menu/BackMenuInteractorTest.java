package use_case.back_menu;

import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteOutputBoundary;

import static org.mockito.Mockito.*;

public class BackMenuInteractorTest {

    @Test
    void testExecute() {
        // Mock the EditNoteOutputBoundary presenter
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);

        // Create an instance of BackMenuInteractor with the mocked presenter
        BackMenuInteractor backMenuInteractor = new BackMenuInteractor(editNotePresenter);

        // Call the method under test
        backMenuInteractor.execute();

        // Verify that the prepareBackMenu method was called on the editNotePresenter
        verify(editNotePresenter).prepareBackMenu();
    }

    @Test
    void testExecuteMultipleTimes() {
        // Mock the EditNoteOutputBoundary presenter
        EditNoteOutputBoundary editNotePresenter = mock(EditNoteOutputBoundary.class);

        // Create an instance of BackMenuInteractor with the mocked presenter
        BackMenuInteractor backMenuInteractor = new BackMenuInteractor(editNotePresenter);

        // Call the method under test multiple times
        backMenuInteractor.execute();
        backMenuInteractor.execute();
        backMenuInteractor.execute();

        // Verify that the prepareBackMenu method was called on the editNotePresenter exactly 3 times
        verify(editNotePresenter, times(3)).prepareBackMenu();
    }
}
