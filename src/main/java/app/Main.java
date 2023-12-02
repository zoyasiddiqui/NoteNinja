package app;

import data_access.CreateAISnippetDataAccessObject;
import data_access.CreateCodeSnippetDataAccessObject;
import data_access.NoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;
import view.EditNoteView;
import view.HomeView;
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
        CreateNoteViewModel createNoteViewModel = new CreateNoteViewModel();

        // Create DAOs
        NoteDataAccessObject editNoteDataAccessObject = new NoteDataAccessObject();
        CreateAISnippetDataAccessInterface createAISnippetDataAccessObject = new CreateAISnippetDataAccessObject();
        CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject = new CreateCodeSnippetDataAccessObject();

        HomeView homeView = HomeViewUseCaseFactory.create(viewManagerModel, createNoteViewModel,
                editViewModel, searchViewModel, editNoteDataAccessObject);
        views.add(homeView, homeView.viewName);

        EditNoteView noteEditorView = EditNoteUseCaseFactory.create(viewManagerModel,
                                                                    editViewModel,
                                                                    createNoteViewModel,
                                                                    searchViewModel,
                                                                    editNoteDataAccessObject,
                                                                    createAISnippetDataAccessObject,
                                                                    createCodeSnippetDataAccessObject);
        views.add(noteEditorView, noteEditorView.viewName);

        SearchNotesView searchNotesView = SearchNotesUseCase.create(viewManagerModel, createNoteViewModel, editViewModel,
                searchViewModel, editNoteDataAccessObject);
        views.add(searchNotesView, searchNotesView.viewName);

        viewManagerModel.setActiveView(homeView.viewName);
        viewManagerModel.firePropertyChanged();

        // Start the application maximized
        application.setExtendedState(JFrame.MAXIMIZED_BOTH);
        application.setVisible(true);

    }
}
