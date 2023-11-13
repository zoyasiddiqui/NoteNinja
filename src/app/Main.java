package app;

import entity.Note.CommonNoteFactory;
import entity.Note.NoteFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.edit_note.EditViewModel;
import interface_adapter.search_notes.SearchViewModel;
import view.NoteEditorView;
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
        EditViewModel editViewModel = new EditViewModel();

        NoteFactory noteFactory = new CommonNoteFactory();

        //note: when you click create note and edit a note and then you want to go back to searchnotesview,
        //you should create a new searchnotesview.
        SearchNotesView searchNotesView = SearchNotesUseCaseFactory.create(viewManagerModel, searchViewModel, editViewModel);
        views.add(searchNotesView, searchNotesView.viewName);

        NoteEditorView noteEditorView = new NoteEditorView(editViewModel);
        views.add(noteEditorView, noteEditorView.viewName);

        viewManagerModel.setActiveView(searchNotesView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
