package app;

import entity.Note.CommonNoteFactory;
import entity.Note.Note;
import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.edit_note.RenameNoteController;
import interface_adapter.save_note.SaveController;
import interface_adapter.search_notes.SearchViewModel;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.rename_note.RenameNoteInputBoundary;
import use_case.rename_note.RenameNoteInteractor;
import use_case.save_note.SaveNoteInteractor;
import view.EditNoteView;

public class EditNoteUseCaseFactory {

    EditNoteUseCaseFactory() {}

    public static EditNoteView create(
            ViewManagerModel viewManagerModel,
            EditNoteViewModel editNoteViewModel,
            SearchViewModel searchViewModel,
            EditNoteDataAccessInterface editNoteDataAccessInterface) {

        EditNotePresenter editNotePresenter = createEditNotePresenter(searchViewModel, editNoteViewModel, viewManagerModel);
        RenameNoteController renameUseCase = createRenameUseCase(editNotePresenter);

        Note note = editNoteViewModel.getState().getNote();
        SaveController saveNoteUseCase = createSaveUseCase(editNotePresenter, editNoteDataAccessInterface);

        // feel free to add more controllers and view models as necessary
        return new EditNoteView(note, editNoteViewModel, renameUseCase, saveNoteUseCase);

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


    private static SaveController createSaveUseCase(EditNotePresenter editNotePresenter,
                                                    EditNoteDataAccessInterface editNoteDataAccessInterface) {

        // we need a noteFactory for SaveNoteInteractor, so it can create a note entity when saving new notes.
        NoteFactory noteFactory = new CommonNoteFactory();
        SaveNoteInteractor saveNoteInteractor = new SaveNoteInteractor(editNoteDataAccessInterface, editNotePresenter, noteFactory);
        return new SaveController(saveNoteInteractor);
    }
}
