package view;

import data_access.NoteDataAccessObject;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;
import interface_adapter.switch_to_search.SwitchToSearchController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "create note";
    private final CreateNoteViewModel createNoteViewModel;
    private final CreateNoteController createNoteController;
    private final SwitchToSearchController searchController;
    private final JButton createNote;
    private final JButton searchNotes;
    private final JLabel homeTitle;

    public HomeView(CreateNoteViewModel createNoteViewModel,
                    CreateNoteController createNoteController,
                    SwitchToSearchController searchController) {
        this.createNoteViewModel = createNoteViewModel;
        this.createNoteController = createNoteController;
        this.searchController = searchController;
        createNoteViewModel.addPropertyChangeListener(this);

        // ==== MAKING BUTTONS/ LABELS ====

        JPanel buttons = new JPanel();
        buttons.setLayout(null);

        // Main title label
        this.homeTitle = new JLabel("NoteNinjas");
        homeTitle.setBounds(30, 0, 200, 100);
        Font largerFont = homeTitle.getFont().deriveFont(Font.ITALIC, 40);
        homeTitle.setFont(largerFont);
        homeTitle.setBounds(300, 100, 400, 400);
        buttons.add(homeTitle);

        // Create Note button
        this.createNote = new JButton(createNoteViewModel.CREATE_BUTTON);
        Font newButtonFont = createNote.getFont().deriveFont(Font.PLAIN, 18);
        createNote.setFont(newButtonFont);
        createNote.setBounds(300, 360, 200, 50);
        buttons.add(createNote);

        // === ADD ACTION LISTENERS ===

        createNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createNote)) {
                            try {
                                createNoteController.execute("Title Note");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        //set second button
        this.searchNotes = new JButton("Search for Notes");
        searchNotes.setFont(newButtonFont);
        searchNotes.setBounds(300, 420, 200, 50);
        buttons.add(searchNotes);

        searchNotes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchController.execute();
                    }
                }
        );
        searchNotes.addActionListener(this);

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