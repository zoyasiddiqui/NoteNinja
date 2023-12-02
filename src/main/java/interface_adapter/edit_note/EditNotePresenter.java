package interface_adapter.edit_note;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.search_notes.SearchState;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_AI_snippet.CreateAISnippetOutputData;
import use_case.create_code_snippet.CreateCodeSnippetOutputData;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import use_case.rename_note.RenameNoteOutputData;
import use_case.search_notes.SearchOutputData;

public class EditNotePresenter implements EditNoteOutputBoundary {
    private final CreateNoteViewModel createNoteViewModel;
    private final EditNoteViewModel editNoteViewModel;
    private final ViewManagerModel viewManagerModel;

    public EditNotePresenter(CreateNoteViewModel createNoteViewModel,
                             EditNoteViewModel editNoteViewModel,
                             ViewManagerModel viewManagerModel) {
        this.createNoteViewModel = createNoteViewModel;
        this.editNoteViewModel = editNoteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

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

    @Override
    public void prepareTitleChange(RenameNoteOutputData title) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteTitle(title.getTitle());
        this.editNoteViewModel.setState(noteState);
        this.editNoteViewModel.firePropertyChanged();
    }

    @Override
    public void prepareBackMenu() {
        viewManagerModel.setActiveView(createNoteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

}