// Package declaration
package app;

// Import statements for various classes and interfaces
import data_access.CreateAISnippetDataAccessObject;
import data_access.CreateCodeSnippetDataAccessObject;
import data_access.NoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchViewModel;
import use_case.create_AI_snippet.CreateAISnippetDataAccessInterface;
import use_case.create_code_snippet.CreateCodeSnippetDataAccessInterface;
import view.EditNoteView;
import view.HomeView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

// Class declaration
public class Main {

    // Main method
    public static void main(String[] args) throws IOException {

        // The main application window.
        JFrame application = new JFrame("Trial");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set up CardLayout for managing different views
        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // Create view models for different views
        SearchViewModel searchViewModel = new SearchViewModel();
        EditNoteViewModel editViewModel = new EditNoteViewModel();

        // Create DAOs for data access
        NoteDataAccessObject editNoteDataAccessObject = new NoteDataAccessObject();
        CreateAISnippetDataAccessInterface createAISnippetDataAccessObject = new CreateAISnippetDataAccessObject();
        CreateCodeSnippetDataAccessInterface createCodeSnippetDataAccessObject = new CreateCodeSnippetDataAccessObject();

        // Create HomeView using the factory method
        HomeView homeView = HomeViewUseCaseFactory.create(
                viewManagerModel,
                editViewModel,
                searchViewModel,
                editNoteDataAccessObject);

        // Add HomeView to the views panel
        views.add(homeView, homeView.viewName);

        // Create EditNoteView using the factory method
        EditNoteView noteEditorView = EditNoteUseCaseFactory.create(viewManagerModel,
                editViewModel,
                searchViewModel,
                editNoteDataAccessObject,
                createAISnippetDataAccessObject,
                createCodeSnippetDataAccessObject);

        // Add EditNoteView to the views panel
        views.add(noteEditorView, noteEditorView.viewName);

        // Set HomeView as the active view
        viewManagerModel.setActiveView(homeView.viewName);

        // Fire property change to update the UI
        viewManagerModel.firePropertyChanged();

        // Start the application maximized
        application.setExtendedState(JFrame.MAXIMIZED_BOTH);
        application.setVisible(true);
    }
}
