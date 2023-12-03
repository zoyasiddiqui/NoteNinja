package interface_adapter.edit_note;

import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class EditNoteViewModelTest {

    @Test
    void testSetNoteTitle() {
        // Arrange
        EditNoteViewModel viewModel = new EditNoteViewModel();
        PropertyChangeListener mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);

        // Act
        viewModel.setNoteTitle("New Note Title");

    }

    @Test
    void testFirePropertyChanged() {
        // Arrange
        EditNoteViewModel viewModel = new EditNoteViewModel();
        PropertyChangeListener mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);

        // Act
        viewModel.firePropertyChanged();

        // Assert
        // Verify that the property change event is fired for the "state" property
        verify(mockListener, times(1)).propertyChange(any());
    }

    @Test
    void testAddPropertyChangeListener() {
        // Arrange
        EditNoteViewModel viewModel = new EditNoteViewModel();
        PropertyChangeListener mockListener = mock(PropertyChangeListener.class);

        // Act
        viewModel.addPropertyChangeListener(mockListener);

        // Assert
        // Verify that the listener is added
        assertTrue(viewModel.support.hasListeners("state"));
    }

    @Test
    void testSetState() {
        // Arrange
        EditNoteViewModel viewModel = new EditNoteViewModel();
        PropertyChangeListener mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);

        // Act
        viewModel.setState(new EditNoteState());

    }
}
