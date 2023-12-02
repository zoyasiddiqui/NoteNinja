// Package declaration
package interface_adapter.create_note;

// Import statements for various classes and interfaces
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_note.CreateNoteOutputBoundary;
import use_case.create_note.CreateNoteOutputData;

// Class declaration for CreateNotePresenter implementing CreateNoteOutputBoundary
public class CreateNotePresenter implements CreateNoteOutputBoundary {

    // Private member variables to hold instances of related view models and the view manager
    private final SearchViewModel searchViewModel;
    private final EditNoteViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    // Constructor to initialize CreateNotePresenter with SearchViewModel, EditNoteViewModel, and ViewManagerModel
    public CreateNotePresenter(SearchViewModel searchViewModel, EditNoteViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    // Method to prepare the success view
    @Override
    public void prepareSuccessView(CreateNoteOutputData response) {
        // Set the active view to the edit view
        viewManagerModel.setActiveView(editViewModel.getViewName());
        // Notify observers about the property change
        viewManagerModel.firePropertyChanged();
    }

    // Method to prepare the failure view
    @Override
    public void prepareFailView(String error) {
        // Set the active view to the search view
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        // Notify observers about the property change
        searchViewModel.firePropertyChanged();
    }
}
