package interface_adapter;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ViewManagerModelTest {

    @Test
    void testGetActiveViewAndSetActiveView() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();

        // Act
        viewManagerModel.setActiveView("Test View");

        // Assert
        // Verify that getActiveView returns the correct active view name
        assertEquals("Test View", viewManagerModel.getActiveView());
    }

    @Test
    void testPropertyChangeSupport() {
        // Arrange
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        TestPropertyChangeListener listener = new TestPropertyChangeListener();

        // Act
        viewManagerModel.addPropertyChangeListener(listener);
        viewManagerModel.firePropertyChanged();

        // Assert
        // Verify that the listener was notified of the property change
        assertTrue(listener.propertyChangeCalled);
        // Verify that the property name is correct
        assertEquals("view", listener.propertyName);
        // Verify that the old value is null
        assertNull(listener.oldValue);
        // Verify that the new value is the current active view name
        assertEquals(viewManagerModel.getActiveView(), listener.newValue);
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
