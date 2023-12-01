package interface_adapter.create_AI_snippet;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteState;
import interface_adapter.edit_note.EditNoteViewModel;
import use_case.create_AI_snippet.CreateAISnippetOutputBoundary;
import use_case.create_AI_snippet.CreateAISnippetOutputData;

public class CreateAISnippetPresenter implements CreateAISnippetOutputBoundary {
    private final EditNoteViewModel editViewModel;
    private final ViewManagerModel viewManagerModel;

    public CreateAISnippetPresenter(EditNoteViewModel editViewModel, ViewManagerModel viewManagerModel) {
        this.editViewModel = editViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CreateAISnippetOutputData response) {
        EditNoteState noteState = editViewModel.getState();
        noteState.setNoteText(response.getText());
        this.editViewModel.setState(noteState);
        this.editViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(editViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}