package interface_adapter.search_notes;

import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.junit.jupiter.api.Assertions.*;

class SearchViewModelTest {

    @Test
    void testDefaultConstructor() {
        // Arrange and Act
        SearchViewModel searchViewModel = new SearchViewModel();

        // Assert
        // Verify that the state is not null by default
        assertNotNull(searchViewModel.getState());
    }

    @Test
    void testGetStateAndSetState() {
        // Arrange
        SearchViewModel searchViewModel = new SearchViewModel();
        SearchState newState = new SearchState();

        // Act
        searchViewModel.setState(newState);

        // Assert
        // Verify that getState returns the same state that was set
        assertEquals(newState, searchViewModel.getState());
    }

    @Test
    void testPropertyChangeSupport() {
        // Arrange
        SearchViewModel searchViewModel = new SearchViewModel();
        TestPropertyChangeListener listener = new TestPropertyChangeListener();

        // Act
        searchViewModel.addPropertyChangeListener(listener);
        searchViewModel.firePropertyChanged();

        // Assert
        // Verify that the listener was notified of the property change
        assertTrue(listener.propertyChangeCalled);
        // Verify that the property name is correct
        assertEquals("state", listener.propertyName);
        // Verify that the old value is null
        assertNull(listener.oldValue);
        // Verify that the new value is the current state
        assertEquals(searchViewModel.getState(), listener.newValue);
    }

    private static class TestPropertyChangeListener implements PropertyChangeListener {
        boolean propertyChangeCalled = false;
        String propertyName;
        Object oldValue;
        Object newValue;

        @Override
        public void propertyChange(java.beans.PropertyChangeEvent evt) {
            propertyChangeCalled = true;
            propertyName = evt.getPropertyName();
            oldValue = evt.getOldValue();
            newValue = evt.getNewValue();
        }
    }
}
