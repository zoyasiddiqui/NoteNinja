// Package declaration
package app;

// Import statements for various classes and interfaces
import interface_adapter.ViewManagerModel;
import interface_adapter.back_menu.BackMenuController;
import interface_adapter.back_menu.BackMenuPresenter;
import interface_adapter.create_AI_snippet.CreateAISnippetController;
import interface_adapter.create_code_snippet.CreateCodeSnippetController;
import interface_adapter.edit_note.EditController;
import interface_adapter.rename_note.RenameNotePresenter;
import interface_adapter.search_notes.SearchViewModel;
import interface_adapter.delete_note.DeleteNoteController;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.rename_note.RenameNoteController;
import use_case.back_menu.BackMenuInputBoundary;
import use_case.back_menu.BackMenuInteractor;
import use_case.back_menu.BackMenuOutputBoundary;
import use_case.create_AI_snippet.*;
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;
import use_case.create_code_snippet.CreateCodeSnippetInputBoundary;
import use_case.create_code_snippet.CreateCodeSnippetInteractor;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.delete_note.DeleteNoteInputBoundary;
import use_case.delete_note.DeleteNoteInteractor;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteInputBoundary;
import use_case.edit_note.EditNoteInteractor;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.rename_note.RenameNoteInputBoundary;
import use_case.rename_note.RenameNoteInteractor;
import use_case.rename_note.RenameNoteOutputBoundary;
import view.EditNoteView;


// Class declaration
public class EditNoteUseCaseFactory {

    // Default constructor
    EditNoteUseCaseFactory() {}

    // Factory method to create an EditNoteView
    public static EditNoteView create(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel,
            SearchViewModel searchViewModel,
            EditNoteDataAccessInterface editNoteDataAccessInterface,
            CreateAISnippetDataAccessInterface createAISnippetDataAccessInterface,
            CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessInterface,
            DeleteNoteDataAccessInterface deleteNoteDataAccessInterface) {

        // we need a renaming controller, an editing controller, a back menu controller,
        // an ai snippet controller, a code snippet controller, and a delete note controller
        RenameNoteController renameNote = createRenameUseCase(editNoteViewModel, editNoteDataAccessInterface);
        EditController edit = createEditUseCase(viewManagerModel, searchViewModel,
                editNoteViewModel, editNoteDataAccessInterface);
        CreateAISnippetController aiSnippet = createAISnippetUseCase(viewManagerModel, searchViewModel,
                editNoteViewModel, createAISnippetDataAccessInterface);
        CreateCodeSnippetController codeSnippet = createCodeSnippetUseCase(viewManagerModel, searchViewModel,
                editNoteViewModel, createCodeSnippetDataAccessInterface);
        BackMenuController backMenu = createBackMenuUseCase(viewManagerModel, searchViewModel);
        DeleteNoteController deleteNote = createDeleteNoteUseCase(viewManagerModel, searchViewModel,
                deleteNoteDataAccessInterface);


        // Return an instance of EditNoteView with the created controllers
        return new EditNoteView(editNoteViewModel, renameNote, edit, backMenu, deleteNote,
                aiSnippet, codeSnippet);

    }

    private static RenameNoteController createRenameUseCase(EditNoteViewModel editNoteViewModel,
                                                            EditNoteDataAccessInterface editNoteDataAccessInterface) {
        RenameNoteOutputBoundary renameNoteOutputBoundary = new RenameNotePresenter(editNoteViewModel);
        RenameNoteInputBoundary renameNoteInputBoundary = new RenameNoteInteractor(renameNoteOutputBoundary,
                editNoteDataAccessInterface);
        return new RenameNoteController(renameNoteInputBoundary);
    }

    private static EditController createEditUseCase(ViewManagerModel viewManagerModel,
                                                    SearchViewModel searchViewModel,
                                                    EditNoteViewModel editNoteViewModel,
                                                    EditNoteDataAccessInterface editNoteDataAccessInterface) {

        EditNoteOutputBoundary editNoteOutputBoundary = new EditNotePresenter(searchViewModel, editNoteViewModel, viewManagerModel);
        EditNoteInputBoundary editNoteInputBoundary = new EditNoteInteractor(editNoteDataAccessInterface, editNoteOutputBoundary);
        return new EditController(editNoteInputBoundary);
    }

    private static CreateAISnippetController createAISnippetUseCase(ViewManagerModel viewManagerModel,
                                                                    SearchViewModel searchViewModel,
                                                                    EditNoteViewModel editNoteViewModel,
                                                                    CreateAISnippetDataAccessInterface createAISnippetDataAccessInterface) {
        EditNoteOutputBoundary editNoteOutputBoundary = new EditNotePresenter(searchViewModel, editNoteViewModel, viewManagerModel);
        CreateAISnippetInputBoundary createAISnippetInputBoundary =
                new CreateAISnippetInteractor(createAISnippetDataAccessInterface, editNoteOutputBoundary);
        return new CreateAISnippetController(createAISnippetInputBoundary);
    }

    private static CreateCodeSnippetController createCodeSnippetUseCase(ViewManagerModel viewManagerModel,
                                                                        SearchViewModel searchViewModel,
                                                                        EditNoteViewModel editNoteViewModel,
                                                                        CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessInterface) {
        EditNoteOutputBoundary editNoteOutputBoundary = new EditNotePresenter(searchViewModel, editNoteViewModel, viewManagerModel);
        CreateCodeSnippetInputBoundary createCodeSnippetInputBoundary = new CreateCodeSnippetInteractor(createCodeSnippetDataAccessInterface, editNoteOutputBoundary);
        return new CreateCodeSnippetController(createCodeSnippetInputBoundary);
    }

    private static BackMenuController createBackMenuUseCase(ViewManagerModel viewManagerModel,
                                                            SearchViewModel searchViewModel) {
        BackMenuOutputBoundary backMenuOutputBoundary = new BackMenuPresenter(viewManagerModel, searchViewModel);
        BackMenuInputBoundary backMenuInputBoundary = new BackMenuInteractor(backMenuOutputBoundary);
        return new BackMenuController(backMenuInputBoundary);
    }

    private static DeleteNoteController createDeleteNoteUseCase(ViewManagerModel viewManagerModel,
                                                                SearchViewModel searchViewModel,
                                                                DeleteNoteDataAccessInterface deleteNoteDataAccessInterface) {
        BackMenuOutputBoundary backMenuOutputBoundary = new BackMenuPresenter(viewManagerModel, searchViewModel);
        DeleteNoteInputBoundary deleteNoteInputBoundary = new DeleteNoteInteractor(backMenuOutputBoundary, deleteNoteDataAccessInterface);
        return new DeleteNoteController(deleteNoteInputBoundary);
    }

}
