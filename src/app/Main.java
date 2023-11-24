package app;

import data_access.CreateAISnippetDataAccessObject;
import data_access.EditNoteDataAccessObject;
import entity.Note.CommonNoteFactory;
import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import view.EditNoteView;
import view.SearchNotesView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // The main application window.
        JFrame application = new JFrame("Trial");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // Create view models and views to add to list of accessible views
        SearchViewModel searchViewModel = new SearchViewModel();
        EditNoteViewModel editViewModel = new EditNoteViewModel();

        EditNoteDataAccessObject editNoteDataAccessObject = new EditNoteDataAccessObject();
        CreateAISnippetDataAccessInterface createAISnippetDataAccessObject = new CreateAISnippetDataAccessObject();
        // TODO: Change or remove noteName attribute. Note sure yet, right now it's set to "dummy"

        NoteFactory noteFactory = new CommonNoteFactory();

        //note: when you click create note and edit a note, and then you want to go back to SearchNotesView,
        //you should create a new SearchNotesView.
        SearchNotesView searchNotesView = SearchNotesUseCaseFactory.create(viewManagerModel, searchViewModel, editViewModel, editNoteDataAccessObject);
        views.add(searchNotesView, searchNotesView.viewName);

        EditNoteView noteEditorView = EditNoteUseCaseFactory.create(viewManagerModel, editViewModel, searchViewModel, editNoteDataAccessObject, createAISnippetDataAccessObject);
        views.add(noteEditorView, noteEditorView.viewName);

        viewManagerModel.setActiveView(searchNotesView.viewName);
        viewManagerModel.firePropertyChanged();

        // Start the application maximized
        application.setExtendedState(JFrame.MAXIMIZED_BOTH);
        application.setVisible(true);

    }
}
