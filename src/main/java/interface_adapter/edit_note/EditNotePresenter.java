// Package declaration
package interface_adapter.edit_note;

// Import statements for various classes and interfaces
import interface_adapter.ViewManagerModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import use_case.rename_note.RenameNoteOutputData;

// Class declaration for EditNotePresenter implementing EditNoteOutputBoundary
public class EditNotePresenter implements EditNoteOutputBoundary {

    // Instance variables for associated ViewModels and ViewManagerModel
    private final SearchViewModel searchNoteViewModel;
    private final EditNoteViewModel editNoteViewModel;
    private final ViewManagerModel viewManagerModel;

    // Constructor for initializing the EditNotePresenter with ViewModels and ViewManagerModel
    public EditNotePresenter(SearchViewModel searchNoteViewModel,
                             EditNoteViewModel editNoteViewModel,
                             ViewManagerModel viewManagerModel) {
        this.searchNoteViewModel = searchNoteViewModel;
        this.editNoteViewModel = editNoteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    // Method to prepare the note view
    @Override
    public void prepareNote(EditNoteOutputData note) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteTitle(note.getNoteTitle());
        noteState.setNoteText(note.getNoteText());
        this.editNoteViewModel.setState(noteState);
        this.editNoteViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(editNoteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}
