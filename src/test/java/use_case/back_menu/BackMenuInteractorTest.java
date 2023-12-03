package use_case.back_menu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.edit_note.EditNoteOutputBoundary;

public class BackMenuInteractorTest {

    @Test
    void testExecute() {
        // Mock the EditNoteOutputBoundary presenter
        EditNoteOutputBoundary editNotePresenter = Mockito.mock(EditNoteOutputBoundary.class);

        // Create an instance of BackMenuInteractor with the mocked presenter
        BackMenuInteractor backMenuInteractor = new BackMenuInteractor(editNotePresenter);

        // Call the execute method
        backMenuInteractor.execute();

        // Verify that the prepareBackMenu method on the presenter is called
        Mockito.verify(editNotePresenter, Mockito.times(1)).prepareBackMenu();
    }

    @Test
    void testConstructor() {
        // Mock the EditNoteOutputBoundary presenter
        EditNoteOutputBoundary editNotePresenter = Mockito.mock(EditNoteOutputBoundary.class);

        // Create an instance of BackMenuInteractor with the mocked presenter
        BackMenuInteractor backMenuInteractor = new BackMenuInteractor(editNotePresenter);

        // Assert that the editNotePresenter instance variable is set
        assertNotNull(backMenuInteractor.editNotePresenter);
        assertEquals(editNotePresenter, backMenuInteractor.editNotePresenter);
    }
}