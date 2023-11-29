package interface_adapter.create_code_snippet;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import use_case.create_code_snippet.CreateCodeSnippetOutputBoundary;
import use_case.create_code_snippet.CreateCodeSnippetOutputData;

public class CreateCodeSnippetPresenter implements CreateCodeSnippetOutputBoundary {
    private final EditNoteViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateCodeSnippetPresenter(EditNoteViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CreateCodeSnippetOutputData response) {
        viewManagerModel.setActiveView(editViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // Implement the logic for handling failure view
    }
}
