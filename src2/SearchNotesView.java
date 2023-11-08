package view;

import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchState;
import interface_adapter.search_notes.SearchViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class SearchNotesView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "search notes";
    private final SearchViewModel searchViewModel;
    private final SearchController searchController;
    private final JButton createNote;

    public SearchNotesView(SearchViewModel searchViewModel, SearchController searchController) {
        this.searchViewModel = searchViewModel;
        this.searchController = searchController;

        JPanel buttons = new JPanel();
        this.createNote = new JButton(searchViewModel.CREATE_BUTTON);
        buttons.add(createNote);

        createNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createNote)) {
                            SearchState state = searchViewModel.getState();
                            try {
                                searchController.execute(state.getSearchBar());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}