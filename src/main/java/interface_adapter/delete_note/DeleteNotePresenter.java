// Package declaration
package interface_adapter.delete_note;

// Import statements for classes and interfaces
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.delete_note.DeleteNoteOutputBoundary;
import use_case.delete_note.DeleteNoteOutputData;

// Class declaration for DeleteNotePresenter implementing DeleteNoteOutputBoundary
public class DeleteNotePresenter implements DeleteNoteOutputBoundary {

    // Instance variables for the associated view models and view manager
    private final SearchViewModel searchViewModel;
    private final EditNoteViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    // Constructor for initializing the DeleteNotePresenter with view models and view manager
    public DeleteNotePresenter(SearchViewModel searchViewModel, EditNoteViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    // Method to prepare the success view based on the DeleteNoteOutputData
    @Override
    public void prepareSuccessView(DeleteNoteOutputData response) {
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // Method to prepare the failure view based on the error message
    @Override
    public void prepareFailView(String error) {
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        searchViewModel.firePropertyChanged();
    }
}
