package interface_adapter.create_code_snippet;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateCodeSnippetViewModel extends ViewModel {

    // TODO: Modify constructor as needed
    public CreateCodeSnippetViewModel(String viewName) {
        super(viewName);
    }

    @Override
    public void firePropertyChanged() {
        // Implement the logic to notify property change
        // You may need to specify which property has changed and notify listeners accordingly
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        // Implement the logic to add property change listeners
    }
}
