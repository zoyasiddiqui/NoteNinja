package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import org.junit.jupiter.api.Test;
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import view.EditNoteView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.withSettings;

class EditNoteUseCaseFactoryTest {

    @Test
    void testCreateEditNoteView() {

        ViewManagerModel viewManagerModel = mock(ViewManagerModel.class);
        EditNoteViewModel editNoteViewModel = mock(EditNoteViewModel.class);
        SearchViewModel searchViewModel = mock(SearchViewModel.class);




        EditNoteDataAccessInterface editNoteDataAccessInterface = mock(EditNoteDataAccessInterface.class, withSettings().extraInterfaces(CreateAISnippetDataAccessInterface.class, CreateCodeSnippetDataAccessInterface.class));

        EditNoteView editNoteView = EditNoteUseCaseFactory.create(
                viewManagerModel,
                editNoteViewModel,
                searchViewModel,
                editNoteDataAccessInterface,
                (CreateAISnippetDataAccessInterface) editNoteDataAccessInterface,
                (CreateCodeSnippetDataAccessInterface) editNoteDataAccessInterface
        );


    }
}
