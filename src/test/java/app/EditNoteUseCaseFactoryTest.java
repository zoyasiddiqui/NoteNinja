package app;

import static org.junit.jupiter.api.Assertions.*;

import interface_adapter.ViewManagerModel;
import interface_adapter.back_menu.BackMenuController;
import interface_adapter.create_AI_snippet.CreateAISnippetController;
import interface_adapter.create_code_snippet.CreateCodeSnippetController;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.delete_note.DeleteNoteController;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.edit_note.RenameNoteController;
import interface_adapter.save_note.SaveController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;

public class EditNoteUseCaseFactoryTest {

    @Test
    void testCreateEditNotePresenter() {
        // Mock dependencies
        CreateNoteViewModel createNoteViewModel = Mockito.mock(CreateNoteViewModel.class);
        EditNoteViewModel editNoteViewModel = Mockito.mock(EditNoteViewModel.class);
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);

        // Create an instance of EditNotePresenter using the helper method
        EditNotePresenter editNotePresenter = EditNoteUseCaseFactory.createEditNotePresenter(
                createNoteViewModel,
                editNoteViewModel,
                viewManagerModel
        );

        // Assert that the EditNotePresenter is not null
        assertNotNull(editNotePresenter);
    }

    @Test
    void testCreateBackMenuUseCase() {
        // Mock dependencies
        EditNoteOutputBoundary editNotePresenter = Mockito.mock(EditNoteOutputBoundary.class);

        // Create an instance of BackMenuController using the helper method
        BackMenuController backMenuController = EditNoteUseCaseFactory.createBackMenuUseCase(editNotePresenter);

        // Assert that the BackMenuController is not null
        assertNotNull(backMenuController);
    }

    @Test
    void testCreateDeleteNoteUseCase() {
        // Mock dependencies
        EditNoteOutputBoundary editNotePresenter = Mockito.mock(EditNoteOutputBoundary.class);
        DeleteNoteDataAccessInterface deleteNoteDataAccessInterface = Mockito.mock(DeleteNoteDataAccessInterface.class);

        // Create an instance of DeleteNoteController using the helper method
        DeleteNoteController deleteNoteController = EditNoteUseCaseFactory.createDeleteNoteUseCase(
                editNotePresenter,
                deleteNoteDataAccessInterface
        );

        // Assert that the DeleteNoteController is not null
        assertNotNull(deleteNoteController);
    }

    @Test
    void testCreateRenameUseCase() {
        // Mock dependencies
        EditNoteOutputBoundary editNotePresenter = Mockito.mock(EditNoteOutputBoundary.class);
        EditNoteDataAccessInterface editNoteDataAccessInterface = Mockito.mock(EditNoteDataAccessInterface.class);

        // Create an instance of RenameNoteController using the helper method
        RenameNoteController renameNoteController = EditNoteUseCaseFactory.createRenameUseCase(
                editNotePresenter,
                editNoteDataAccessInterface
        );

        // Assert that the RenameNoteController is not null
        assertNotNull(renameNoteController);
    }

    @Test
    void testCreateSaveUseCase() {
        // Mock dependencies
        EditNoteDataAccessInterface editNoteDataAccessInterface = Mockito.mock(EditNoteDataAccessInterface.class);
        EditNoteOutputBoundary editNotePresenter = Mockito.mock(EditNoteOutputBoundary.class);

        // Create an instance of SaveController using the helper method
        SaveController saveController = EditNoteUseCaseFactory.createSaveUseCase(
                editNoteDataAccessInterface,
                editNotePresenter
        );

        // Assert that the SaveController is not null
        assertNotNull(saveController);
    }

    @Test
    void testCreateAISnippetUseCase() {
        // Mock dependencies
        EditNoteOutputBoundary editNotePresenter = Mockito.mock(EditNoteOutputBoundary.class);
        CreateAISnippetDataAccessInterface createAISnippetDataAccessInterface = Mockito.mock(CreateAISnippetDataAccessInterface.class);

        // Create an instance of CreateAISnippetController using the helper method
        CreateAISnippetController createAISnippetController = EditNoteUseCaseFactory.createAISnippetUseCase(
                editNotePresenter,
                createAISnippetDataAccessInterface
        );

        // Assert that the CreateAISnippetController is not null
        assertNotNull(createAISnippetController);
    }

    @Test
    void testCreateCodeSnippetUseCase() {
        // Mock dependencies
        EditNoteOutputBoundary editNotePresenter = Mockito.mock(EditNoteOutputBoundary.class);
        CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessInterface = Mockito.mock(CreateCodeSnippetDataAccessInterface.class);

        // Create an instance of CreateCodeSnippetController using the helper method
        CreateCodeSnippetController createCodeSnippetController = EditNoteUseCaseFactory.createCodeSnippetUseCase(
                editNotePresenter,
                createCodeSnippetDataAccessInterface
        );

        // Assert that the CreateCodeSnippetController is not null
        assertNotNull(createCodeSnippetController);
    }
}
