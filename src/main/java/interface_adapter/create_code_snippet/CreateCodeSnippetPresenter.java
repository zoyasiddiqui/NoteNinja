// Package declaration
package interface_adapter.create_code_snippet;

// Import statements for various classes and interfaces
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import use_case.create_code_snippet.CreateCodeSnippetOutputBoundary;
import use_case.create_code_snippet.CreateCodeSnippetOutputData;

// Class declaration for CreateCodeSnippetPresenter
public class CreateCodeSnippetPresenter implements CreateCodeSnippetOutputBoundary {

    // Private member variables to hold EditNoteViewModel and ViewManagerModel instances
    private final EditNoteViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    // Constructor to initialize CreateCodeSnippetPresenter with EditNoteViewModel and ViewManagerModel
    public CreateCodeSnippetPresenter(EditNoteViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    // Implementation of the success view preparation method
    @Override
    public void prepareSuccessView(CreateCodeSnippetOutputData response) {
        // Set the active view in ViewManagerModel and trigger property change
        viewManagerModel.setActiveView(editViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // Implementation of the failure view preparation method
    @Override
    public void prepareFailView(String error) {
        // Implement the logic for handling failure view if needed
    }
}
