package view;

import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SearchNotesView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "sign up";
    private final SearchViewModel searchViewModel;
    private final SearchController searchController;
    private final JButton createNote;

    public SearchNotesView(SearchViewModel searchViewModel, SearchController searchController) {
        this.searchViewModel = searchViewModel;
        this.searchController = searchController;

        this.createNote = new JButton(searchViewModel.CREATE_BUTTON);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}