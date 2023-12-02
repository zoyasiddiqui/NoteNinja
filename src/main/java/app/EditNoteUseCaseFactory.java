// Package declaration
package app;

// Import statements for various classes and interfaces
import entity.Note.CommonNoteFactory;
import entity.Note.NoteFactory;
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
import interface_adapter.search_notes.SearchViewModel;
import use_case.back_menu.BackMenuInputBoundary;
import use_case.back_menu.BackMenuInteractor;
import use_case.create_AI_snippet.*;
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;
import use_case.create_code_snippet.CreateCodeSnippetInputBoundary;
import use_case.create_code_snippet.CreateCodeSnippetInteractor;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.delete_note.DeleteNoteInputBoundary;
import use_case.delete_note.DeleteNoteInteractor;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.rename_note.RenameNoteInputBoundary;
import use_case.rename_note.RenameNoteInteractor;
import use_case.save_note.SaveNoteInteractor;
import view.EditNoteView;

// Class declaration
public class EditNoteUseCaseFactory {

    // Default constructor
    EditNoteUseCaseFactory() {}

    // Factory method to create an EditNoteView
    public static EditNoteView create(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel,
            CreateNoteViewModel createNoteViewModel,
            SearchViewModel searchViewModel,
            EditNoteDataAccessInterface editNoteDataAccessInterface,
            CreateAISnippetDataAccessInterface createAISnippetDataAccessInterface,
            CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessInterface) {

        // Create an EditNoteOutputBoundary using a helper method
        EditNoteOutputBoundary editNotePresenter = createEditNotePresenter(createNoteViewModel,
                editNoteViewModel, viewManagerModel);

        // Create various controllers for different use cases
        RenameNoteController renameUseCase = createRenameUseCase(editNotePresenter, editNoteDataAccessInterface);

        SaveController saveNoteUseCase = createSaveUseCase(editNoteDataAccessInterface,
                editNotePresenter);

        BackMenuController backMenuUseCase = createBackMenuUseCase(editNotePresenter);

        DeleteNoteController deleteNoteUseCase = createDeleteNoteUseCase(editNotePresenter,
                (DeleteNoteDataAccessInterface) editNoteDataAccessInterface);

        CreateAISnippetController createAISnippetUseCase = createAISnippetUseCase(editNotePresenter,
                createAISnippetDataAccessInterface);

        CreateCodeSnippetController createCodeSnippetUseCase = createCodeSnippetUseCase(editNotePresenter,
                createCodeSnippetDataAccessInterface);

        // Return an instance of EditNoteView with the created controllers
        return new EditNoteView(editNoteViewModel, renameUseCase, saveNoteUseCase, backMenuUseCase, deleteNoteUseCase, createAISnippetUseCase, createCodeSnippetUseCase);

    }

    // Helper method to create an EditNotePresenter
    private static EditNotePresenter createEditNotePresenter(CreateNoteViewModel createNoteViewModel,
                                                             EditNoteViewModel editNoteViewModel,
                                                             ViewManagerModel viewManagerModel) {
        return new EditNotePresenter(createNoteViewModel, editNoteViewModel, viewManagerModel);
    }

    // Helper method to create a BackMenuController
    private static BackMenuController createBackMenuUseCase(EditNoteOutputBoundary editNotePresenter) {
        BackMenuInputBoundary backMenuInteractor = new BackMenuInteractor(editNotePresenter);
        return new BackMenuController(backMenuInteractor);
    }

    // Helper method to create a DeleteNoteController
    private static DeleteNoteController createDeleteNoteUseCase(EditNoteOutputBoundary editNotePresenter,
                                                                DeleteNoteDataAccessInterface deleteNoteDataAccessInterface) {
        DeleteNoteInputBoundary deleteNoteInteractor = new DeleteNoteInteractor(editNotePresenter, deleteNoteDataAccessInterface);
        return new DeleteNoteController(deleteNoteInteractor);
    }

    // Helper method to create a RenameNoteController
    // Note that we don't pass in any DAO for the RenameUseCase because it does not interact with DAOs
    // RenameUseCase only updates the note's state and fires the property change in view model
    private static RenameNoteController createRenameUseCase(EditNoteOutputBoundary editNotePresenter,
                                                            EditNoteDataAccessInterface editNoteDataAccessInterface) {
        RenameNoteInputBoundary renameNoteInteractor = new RenameNoteInteractor(editNotePresenter, editNoteDataAccessInterface);
        return new RenameNoteController(renameNoteInteractor);
    }

    // Helper method to create a SaveController
    private static SaveController createSaveUseCase(EditNoteDataAccessInterface editNoteDataAccessInterface,
                                                    EditNoteOutputBoundary editNotePresenter) {

        // We need a noteFactory for SaveNoteInteractor, so it can create a note entity when saving new notes.
        NoteFactory noteFactory = new CommonNoteFactory();
        SaveNoteInteractor saveNoteInteractor = new SaveNoteInteractor(editNoteDataAccessInterface, noteFactory, editNotePresenter);
        return new SaveController(saveNoteInteractor);
    }

    // Helper method to create a CreateAISnippetController
    private static CreateAISnippetController createAISnippetUseCase(EditNoteOutputBoundary editNotePresenter,
                                                                    CreateAISnippetDataAccessInterface createAISnippetDataAccessObject) {

        CreateAISnippetInputBoundary createAISnippetInteractor = new CreateAISnippetInteractor(createAISnippetDataAccessObject, editNotePresenter);
        return new CreateAISnippetController(createAISnippetInteractor);
    }

    // Helper method to create a CreateCodeSnippetController
    private static CreateCodeSnippetController createCodeSnippetUseCase(EditNoteOutputBoundary editNotePresenter,
                                                                        CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject) {

        CreateCodeSnippetInputBoundary createCodeSnippetInteractor = new CreateCodeSnippetInteractor(createCodeSnippetDataAccessObject, editNotePresenter);
        return new CreateCodeSnippetController(createCodeSnippetInteractor);
    }
}
