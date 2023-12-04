package app;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import org.junit.jupiter.api.Test;
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import view.EditNoteView;

class EditNoteUseCaseFactoryTest {

    @Test
    void createEditNoteView_Success() {
        // Arrange: Mock dependencies
        ViewManagerModel viewManagerModel = mock(ViewManagerModel.class);
        EditNoteViewModel editNoteViewModel = mock(EditNoteViewModel.class);
        SearchViewModel searchViewModel = mock(SearchViewModel.class);
        EditNoteDataAccessInterface editNoteDataAccessInterface = mock(EditNoteDataAccessInterface.class,
                withSettings().extraInterfaces(DeleteNoteDataAccessInterface.class));
        CreateAISnippetDataAccessInterface createAISnippetDataAccessInterface = mock(CreateAISnippetDataAccessInterface.class);
        CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessInterface = mock(CreateCodeSnippetDataAccessInterface.class);

        // Act
        EditNoteView editNoteView = EditNoteUseCaseFactory.create(
                viewManagerModel,
                editNoteViewModel,
                searchViewModel,
                editNoteDataAccessInterface,
                createAISnippetDataAccessInterface,
                createCodeSnippetDataAccessInterface
        );

        // Assert
        assertNotNull(editNoteView);
        // Add more assertions as needed to verify the state of the created EditNoteView
    }

    // Add more test cases for different scenarios and edge cases
}
