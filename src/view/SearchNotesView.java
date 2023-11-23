package view;

import interface_adapter.create_note.CreateNoteController;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
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
    private final JLabel homeTitle;

    public SearchNotesView(SearchViewModel searchViewModel, SearchController searchController, EditNoteViewModel editViewModel, CreateNoteController createNoteController) {
        this.searchViewModel = searchViewModel;
        this.searchController = searchController;
        this.editViewModel = editViewModel;
        this.createNoteController = createNoteController;
        searchViewModel.addPropertyChangeListener(this);
        editViewModel.addPropertyChangeListener(this);


        // ==== MAKING BUTTONS/ LABELS ====

        JPanel buttons = new JPanel();
        buttons.setLayout(null);

        // Main title label
        this.homeTitle = new JLabel("NoteNinja");
        homeTitle.setBounds(30, 0, 200, 100);
        Font largerFont = homeTitle.getFont().deriveFont(Font.PLAIN, 24); // Change 24 to the desired font size
        homeTitle.setFont(largerFont);
        buttons.add(homeTitle);

        // Create Note button
        this.createNote = new JButton(searchViewModel.CREATE_BUTTON);
        createNote.setBounds(30, 90, 140, 30);
        buttons.add(createNote);

        // ================================


        createNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createNote)) {
                            try {
                                createNoteController.execute("Untitled");
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