package view;

import interface_adapter.create_note.CreateNoteController;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchController;
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
    private final EditNoteViewModel editViewModel;
    private final CreateNoteController createNoteController;
    private final JButton createNote;

    public SearchNotesView(SearchViewModel searchViewModel, SearchController searchController, EditNoteViewModel editViewModel, CreateNoteController createNoteController) {
        this.searchViewModel = searchViewModel;
        this.searchController = searchController;
        this.editViewModel = editViewModel;
        this.createNoteController = createNoteController;
        searchViewModel.addPropertyChangeListener(this);
        editViewModel.addPropertyChangeListener(this);

        JPanel buttons = new JPanel();
        this.createNote = new JButton(searchViewModel.CREATE_BUTTON);
        buttons.add(createNote);

        createNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createNote)) {
                            try {
                                createNoteController.execute("untitled");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}