// Package declaration
package interface_adapter.create_AI_snippet;

// Import statements for various classes and interfaces
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteState;
import interface_adapter.edit_note.EditNoteViewModel;
import use_case.create_AI_snippet.CreateAISnippetOutputBoundary;
import use_case.create_AI_snippet.CreateAISnippetOutputData;

// Class declaration for CreateAISnippetPresenter implementing CreateAISnippetOutputBoundary
public class CreateAISnippetPresenter implements CreateAISnippetOutputBoundary {

    // Private member variables to hold EditNoteViewModel and ViewManagerModel instances
    private final EditNoteViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    // Constructor to initialize the CreateAISnippetPresenter with EditNoteViewModel and ViewManagerModel instances
    public CreateAISnippetPresenter(EditNoteViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    // Implementation of the prepareSuccessView method from the interface
    @Override
    public void prepareSuccessView(CreateAISnippetOutputData response) {
        // Get the current state of the note from the EditNoteViewModel
        EditNoteState noteState = editViewModel.getState();

        // Set the note text with the response text from the CreateAISnippetOutputData
        noteState.setNoteText(response.getText());

        // Update the state in the EditNoteViewModel
        this.editViewModel.setState(noteState);
        this.editViewModel.firePropertyChanged();

        // Set the active view in the ViewManagerModel
        viewManagerModel.setActiveView(editViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // Implementation of the prepareFailView method from the interface
    @Override
    public void prepareFailView(String error) {
        // Implementation for handling failure view preparation if needed
        // (currently left empty in the provided code)
    }
}
