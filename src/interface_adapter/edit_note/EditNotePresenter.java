package interface_adapter.edit_note;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_AI_snippet.CreateAISnippetOutputData;
import use_case.create_code_snippet.CreateCodeSnippetOutputData;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import use_case.rename_note.RenameNoteOutputData;

public class EditNotePresenter implements EditNoteOutputBoundary {
    private final SearchViewModel searchViewModel;
    private final EditNoteViewModel editNoteViewModel;
    private final ViewManagerModel viewManagerModel;

    public EditNotePresenter(SearchViewModel searchViewModel,
                             EditNoteViewModel editNoteViewModel,
                             ViewManagerModel viewManagerModel) {
        this.searchViewModel = searchViewModel;
        this.editNoteViewModel = editNoteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareNote(EditNoteOutputData note) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteTitle(note.getTitle());
        noteState.setNoteID(note.getID());
        noteState.setNoteText(note.getText());
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
    public void prepareAISnippetAdded(CreateAISnippetOutputData text) {
        EditNoteState noteState = editNoteViewModel.getState();
        noteState.setNoteText(text.getText());
        this.editNoteViewModel.setState(noteState);
        this.editNoteViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(editNoteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareBackMenu() {
        viewManagerModel.setActiveView(searchViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareCodeSnippetAdded(CreateCodeSnippetOutputData createCodeSnippetOutputData) {

    }
}