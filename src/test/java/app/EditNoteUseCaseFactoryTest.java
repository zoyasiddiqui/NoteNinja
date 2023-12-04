package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import org.junit.jupiter.api.Test;
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import view.EditNoteView;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

public class EditNoteUseCaseFactoryTest {

    @Test
    void testCreateEditNoteView() {
        // Mock dependencies
        ViewManagerModel viewManagerModel = mock(ViewManagerModel.class);
        EditNoteViewModel editNoteViewModel = mock(EditNoteViewModel.class);
        SearchViewModel searchViewModel = mock(SearchViewModel.class);
        EditNoteDataAccessInterface editNoteDataAccessInterface = mock(EditNoteDataAccessInterface.class);
        CreateAISnippetDataAccessInterface createAISnippetDataAccessInterface = mock(CreateAISnippetDataAccessInterface.class);
        CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessInterface = mock(CreateCodeSnippetDataAccessInterface.class);
        DeleteNoteDataAccessInterface deleteNoteDataAccessInterface = mock(DeleteNoteDataAccessInterface.class);

        // Call the method under test
        EditNoteView editNoteView = EditNoteUseCaseFactory.create(
                viewManagerModel,
                editNoteViewModel,
                searchViewModel,
                editNoteDataAccessInterface,
                createAISnippetDataAccessInterface,
                createCodeSnippetDataAccessInterface,
                deleteNoteDataAccessInterface
        );

        // Assert that the EditNoteView is not null
        assertNotNull(editNoteView);
        // You can add more assertions as needed
    }
}
