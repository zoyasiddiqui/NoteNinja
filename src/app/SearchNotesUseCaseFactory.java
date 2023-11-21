package app;

import data_access.EditNoteDataAccessObject;
import entity.Note.CommonNoteFactory;
import entity.Note.Note;
import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.edit_note.EditPresenter;
import interface_adapter.edit_note.NoteEditViewModel;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchPresenter;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.create_note.CreateNoteInputBoundary;
import use_case.create_note.CreateNoteInteractor;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.search_notes.SearchInputBoundary;
import use_case.search_notes.SearchInteractor;
import use_case.search_notes.SearchNotesAccessInterface;
import use_case.search_notes.SearchOutputBoundary;
import view.SearchNotesView;

import java.io.File;
import java.io.IOException;

public class SearchNotesUseCaseFactory {
    private static Integer noteNum = 0;

    private SearchNotesUseCaseFactory() {}

    public static SearchNotesView create(ViewManagerModel viewManagerModel, SearchViewModel searchViewModel, NoteEditViewModel editViewModel) throws IOException {

        NoteFactory noteFactory = new CommonNoteFactory();
        EditNoteDataAccessObject dataAccessObject = new EditNoteDataAccessObject("./notes/note"+noteNum+".csv",
                noteFactory, "untitled");
        noteNum += 1;

        SearchController searchController = createSearchController(dataAccessObject);
        CreateNoteController createNoteController = createCreateNoteController(searchViewModel, editViewModel, viewManagerModel, noteFactory, dataAccessObject);

        return new SearchNotesView(searchViewModel, searchController, editViewModel, createNoteController);
    }

    private static SearchController createSearchController(EditNoteDataAccessObject dataAccessObject) {

        //need to figure out why we even have this boundary
        SearchOutputBoundary searchOutputBoundary = new SearchPresenter();

        SearchInputBoundary searchNoteInteractor = new SearchInteractor(dataAccessObject);
        return new SearchController(searchNoteInteractor);
    }

    private static CreateNoteController createCreateNoteController(SearchViewModel searchViewModel, NoteEditViewModel editViewModel, ViewManagerModel viewManagerModel,
                                                                   NoteFactory noteFactory, EditNoteDataAccessObject dataAccessObject) {

        EditNoteOutputBoundary editNotePresenter = new EditPresenter(searchViewModel, editViewModel, viewManagerModel);

        CreateNoteInputBoundary createNoteInteractor = new CreateNoteInteractor(noteFactory, dataAccessObject, editNotePresenter);
        return new CreateNoteController(createNoteInteractor);
    }

}
