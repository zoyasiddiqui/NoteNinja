// Package declaration
package view;

// Import statements for various classes and interfaces
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.List;

// Class declaration for HomeView extending JPanel and implementing ActionListener and PropertyChangeListener
public class SearchVIew extends JPanel implements ActionListener, PropertyChangeListener {
    // Constant for viewName
    public final String viewName = "search notes";

    // Instance variables for models, controllers, and UI elements
    private final SearchViewModel searchViewModel;
    private final CreateNoteController createNoteController;
    private final SearchController searchController;
    private final JButton createNote;
    private final JButton searchNotes;
    private final JLabel homeTitle;
    private final JTextField searchBar;

    // fsl:
    private JTextField searchField;
    private JList<String> optionsList;
    private java.util.List<String> allOptions;
    private List<String> filteredOptions;


    // don't need EditViewModel right now, but feel free to add it later if we need to addPropertyChangeListener(this)
    public SearchVIew(SearchViewModel searchViewModel,
                      CreateNoteController createNoteController,
                      SearchController searchController) throws IOException {

        // Initialization of instance variables
        this.searchViewModel = searchViewModel;
        this.createNoteController = createNoteController;
        this.searchController = searchController;
        searchViewModel.addPropertyChangeListener(this);


        // ==== RETRIEVE LIST OF NOTES ====
//        TODO: DO THIS USE CASE AHHHHH!!
//        ArrayList notesList = retrieveController.execute();
        // ================================

        // ==== MAKING BUTTONS/ LABELS ====
        // JPanel for buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(null);

        // Main title label
        this.homeTitle = new JLabel("NoteNinjas");
        buttons.add(homeTitle);

        // Create Note button
        this.createNote = new JButton(searchViewModel.CREATE_BUTTON);
        buttons.add(createNote);

        // === ADD ACTION LISTENERS ===

        // ActionListener for Create Note button
        createNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(createNote)) {
                            try {
                                createNoteController.execute("Untitled", "");
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );

        // Create search bar
        searchBar = new JTextField("");

        // Set second button (Search)
        this.searchNotes = new JButton("Search");
        buttons.add(searchNotes);

        // ActionListener for Search button
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
        // Add this instance as ActionListener for the Search button
        searchNotes.addActionListener(this);

        // Set layout for the main panel
        this.setLayout(new BorderLayout());

        // Add components to the main panel
        this.add(homeTitle);
        this.add(searchBar);
        this.add(buttons);

        // Styling for UI elements

        // Styling title
        homeTitle.setBounds(200, 150, 200, 100);
        Font largerFont = homeTitle.getFont().deriveFont(Font.ITALIC, 40);
        homeTitle.setFont(largerFont);

        // Styling first button (Create Note)
        Font newButtonFont = createNote.getFont().deriveFont(Font.PLAIN, 18);
        createNote.setFont(newButtonFont);
        createNote.setBounds(200, 240, 180, 40);

        // Styling second button (Search)
        searchNotes.setFont(newButtonFont);
        searchNotes.setBounds(810, 410, 180, 40);

        // Styling searchBar
        Font searchFont = searchBar.getFont().deriveFont(Font.PLAIN, 15);
        searchBar.setFont(searchFont);
        searchBar.setBorder(new LineBorder(Color.lightGray, 3));
        searchBar.setBounds(400, 400, 400, 60);

        // Repaint to apply styling changes
        this.repaint();
    }

    // ActionListener method implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        // Empty method required due to interface implementation
    }

    // PropertyChangeListener method implementation
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Empty method required due to interface implementation
    }
}
