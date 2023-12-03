package interface_adapter;

import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ViewModelTest {

    @Test
    void testConstructorAndGetViewName() {
        // Arrange and Act
        TestViewModel viewModel = new TestViewModel("Test View");

        // Assert
        // Verify that the view name is correctly set in the constructor
        assertEquals("Test View", viewModel.getViewName());
    }

    @Test
    void testPropertyChangeSupport() {
        // Arrange
        TestViewModel viewModel = new TestViewModel("Test View");
        TestPropertyChangeListener listener = new TestPropertyChangeListener();

        // Act
        viewModel.addPropertyChangeListener(listener);
        viewModel.firePropertyChanged();

        // Assert
        // Verify that the listener was notified of the property change
        assertTrue(listener.propertyChangeCalled);
        // Verify that the property name is correct
        assertEquals("viewName", listener.propertyName);
        // Verify that the old value is null
        assertNull(listener.oldValue);
        // Verify that the new value is the current view name
        assertEquals(viewModel.getViewName(), listener.newValue);
    }

    private static class TestViewModel extends ViewModel {
        private final PropertyChangeSupport support = new PropertyChangeSupport(this);

        public TestViewModel(String viewName) {
            super(viewName);
        }

        @Override
        public void firePropertyChanged() {
            support.firePropertyChange("viewName", null, this.getViewName());
        }

        @Override
        public void addPropertyChangeListener(PropertyChangeListener listener) {
            support.addPropertyChangeListener(listener);
        }
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
