package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteController;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.edit_note.RenameNoteController;
import interface_adapter.search_notes.SearchViewModel;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.edit_note.EditNoteInputBoundary;
import use_case.edit_note.EditNoteInteractor;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.rename_note.RenameNoteInputBoundary;
import use_case.rename_note.RenameNoteInteractor;
import view.EditNoteView;

import javax.swing.*;
import java.io.IOException;

public class EditNoteUseCaseFactory {

    EditNoteUseCaseFactory() {}

    public static EditNoteView create(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel,
            SearchViewModel searchViewModel,
            EditNoteDataAccessInterface editNoteDataAccessInterface) {

        EditNotePresenter editNotePresenter = createEditNotePresenter(searchViewModel, editNoteViewModel, viewManagerModel);
        EditNoteController editNoteUseCase = createEditNoteUseCase(editNotePresenter, editNoteDataAccessInterface);
        RenameNoteController renameUseCase = createRenameUseCase(editNotePresenter);

        // feel free to add more controllers and view models as necessary
        return new EditNoteView(editNoteViewModel, editNoteUseCase, renameUseCase);

    }

    private static EditNotePresenter createEditNotePresenter(SearchViewModel searchViewModel,
                                                             EditNoteViewModel editNoteViewModel,
                                                             ViewManagerModel viewManagerModel) {
        return new EditNotePresenter(searchViewModel, editNoteViewModel, viewManagerModel);
    }

    // note that we don't pass in any DAO for the RenameUseCase because it does not interact with DAOs
    // RenameUseCase only updates the note's state and fires the property change in view model
    private static RenameNoteController createRenameUseCase(EditNotePresenter editNotePresenter) {
        RenameNoteInputBoundary renameNoteInteractor = new RenameNoteInteractor(editNotePresenter);
        return new RenameNoteController(renameNoteInteractor);
    }

    private static EditNoteController createEditNoteUseCase(
            EditNotePresenter editNotePresenter,
            EditNoteDataAccessInterface editNoteDataAccessInterface) {

        EditNoteInputBoundary editNoteInteractor = new EditNoteInteractor(editNoteDataAccessInterface, editNotePresenter);

        return new EditNoteController(editNoteInteractor);
    }
}
