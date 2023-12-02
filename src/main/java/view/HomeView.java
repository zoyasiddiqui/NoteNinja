package view;

import data_access.NoteDataAccessObject;
import entity.Note.Note;
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.create_note.CreateNoteViewModel;
import interface_adapter.edit_note.EditNotePresenter;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.save_note.SaveController;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchState;
import interface_adapter.search_notes.SearchViewModel;
import org.glassfish.json.JsonUtil;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class HomeView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "create note";
    private final CreateNoteViewModel createNoteViewModel;
    private final CreateNoteController createNoteController;
    private final SearchController searchController;
    private final JButton createNote;
    private final JButton searchNotes;
    private final JLabel homeTitle;
    private final JTextField searchBar;

    public HomeView(CreateNoteViewModel createNoteViewModel,
                    CreateNoteController createNoteController,
                    SearchController searchController) {
        this.createNoteViewModel = createNoteViewModel;
        this.createNoteController = createNoteController;
        this.searchController = searchController;
        createNoteViewModel.addPropertyChangeListener(this);

        // ==== MAKING BUTTONS/ LABELS ====

        JPanel buttons = new JPanel();
        buttons.setLayout(null);

        // Main title label
        this.homeTitle = new JLabel("NoteNinjas");
        buttons.add(homeTitle);

        // Create Note button
        this.createNote = new JButton(createNoteViewModel.CREATE_BUTTON);
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

        //create search bar
        searchBar = new JTextField("");

        //set second button
        this.searchNotes = new JButton("Search");
        buttons.add(searchNotes);

        searchNotes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            searchBar.requestFocus();
                            String search = searchBar.getText();

                            searchController.execute(search);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
        );
        searchNotes.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(homeTitle);
        this.add(searchBar);
        this.add(buttons);

        //styling title
        homeTitle.setBounds(200, 150, 200, 100);
        Font largerFont = homeTitle.getFont().deriveFont(Font.ITALIC, 40);
        homeTitle.setFont(largerFont);

        //styling first button
        Font newButtonFont = createNote.getFont().deriveFont(Font.PLAIN, 18);
        createNote.setFont(newButtonFont);
        createNote.setBounds(200, 240, 180, 40);

        //styling second button
        searchNotes.setFont(newButtonFont);
        searchNotes.setBounds(810, 410, 180, 40);

        //styling searchBar
        Font searchFont = searchBar.getFont().deriveFont(Font.PLAIN, 15);
        searchBar.setFont(searchFont);
        searchBar.setBorder(new LineBorder(Color.lightGray, 3));
        searchBar.setBounds(400, 400, 400, 60);

        this.repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}