package use_case.back_menu;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class BackMenuInteractorTest {

    @Test
    void testExecute() {
        // Mock the BackMenuOutputBoundary presenter
        BackMenuOutputBoundary backMenuPresenter = Mockito.mock(BackMenuOutputBoundary.class);

        // Create an instance of BackMenuInteractor with the mocked presenter
        BackMenuInteractor backMenuInteractor = new BackMenuInteractor(backMenuPresenter);

        // Call the execute method
        backMenuInteractor.execute();

        // Verify that the prepareBackMenu method on the presenter is called
        verify(backMenuPresenter, Mockito.times(1)).prepareBackMenu();
    }

    @Test
    void testConstructor() {
        // Mock the BackMenuOutputBoundary presenter
        BackMenuOutputBoundary backMenuPresenter = Mockito.mock(BackMenuOutputBoundary.class);

        // Create an instance of BackMenuInteractor with the mocked presenter
        BackMenuInteractor backMenuInteractor = new BackMenuInteractor(backMenuPresenter);

        // Assert that the backMenuPresenter instance variable is set
        assert backMenuInteractor.backMenuPresenter != null;
        assert backMenuInteractor.backMenuPresenter.equals(backMenuPresenter);
    }
}
