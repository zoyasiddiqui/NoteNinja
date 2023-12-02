// Package declaration
package interface_adapter.edit_note;

// Import statements for various classes and interfaces
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteViewModel;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import use_case.rename_note.RenameNoteOutputData;

// Class declaration for EditNotePresenter implementing EditNoteOutputBoundary
public class EditNotePresenter implements EditNoteOutputBoundary {

    // Instance variables for associated ViewModels and ViewManagerModel
    private final CreateNoteViewModel createNoteViewModel;
    private final EditNoteViewModel editNoteViewModel;
    private final ViewManagerModel viewManagerModel;

    // Constructor for initializing the EditNotePresenter with ViewModels and ViewManagerModel
    public EditNotePresenter(CreateNoteViewModel createNoteViewModel,
                             EditNoteViewModel editNoteViewModel,
                             ViewManagerModel viewManagerModel) {
        this.createNoteViewModel = createNoteViewModel;
        this.editNoteViewModel = editNoteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    // Method to prepare the note view
    @Override
    public void prepareNote(EditNoteOutputData note) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteTitle(note.getNoteTitle());
        noteState.setNoteText(note.getNoteText());
        noteState.setNoteID(note.getNoteID()); // be careful that createNote is the only one that affects this
        this.editNoteViewModel.setState(noteState);
        this.editNoteViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(editNoteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    // Method to prepare the title change view
    @Override
    public void prepareTitleChange(RenameNoteOutputData title) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteTitle(title.getTitle());
        this.editNoteViewModel.setState(noteState);
        this.editNoteViewModel.firePropertyChanged();
    }

    // Method to prepare the back to menu view
    @Override
    public void prepareBackMenu() {
        viewManagerModel.setActiveView(createNoteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
