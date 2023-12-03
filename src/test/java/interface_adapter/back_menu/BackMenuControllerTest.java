package interface_adapter.back_menu;

import org.junit.jupiter.api.Test;
import use_case.back_menu.BackMenuInputBoundary;

import static junit.framework.TestCase.assertSame;
import static org.mockito.Mockito.*;

class BackMenuControllerTest {

    @Test
    void testExecute() {
        // Arrange
        BackMenuInputBoundary mockBackMenuInteractor = mock(BackMenuInputBoundary.class);
        BackMenuController backMenuController = new BackMenuController(mockBackMenuInteractor);

        // Act
        backMenuController.execute();

        // Assert
        // Verify that the execute method of BackMenuInputBoundary is called exactly once
        verify(mockBackMenuInteractor, times(1)).execute();
    }

    @Test
    void testConstructor() {
        // Arrange
        BackMenuInputBoundary mockBackMenuInteractor = mock(BackMenuInputBoundary.class);

        // Act
        BackMenuController backMenuController = new BackMenuController(mockBackMenuInteractor);

        // Assert
        // Verify that the BackMenuController is initialized with the provided BackMenuInputBoundary
        assertSame(mockBackMenuInteractor, backMenuController.backMenuInteractor);
    }
}
