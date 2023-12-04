// Package declaration
package view;

// Import statements for various classes and interfaces
import interface_adapter.create_note.CreateNoteController;
import interface_adapter.retrieve.RetrieveController;
import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

// Class declaration for HomeView extending JPanel and implementing ActionListener and PropertyChangeListener
public class SearchView extends JPanel implements ActionListener, PropertyChangeListener {
    // Constant for viewName
    public final String viewName = "search notes";

    // Instance variables for models, controllers, and UI elements
    private final SearchViewModel searchViewModel;
    private final CreateNoteController createNoteController;
    private final SearchController searchController;
    private final RetrieveController retrieveController;
    private final JButton createNote;
//    private final JButton searchNotes;
    private final JLabel homeTitle;

    // fsl:
    private JTextField searchField;
    private JList<OptionItem> optionsList;
    private List<OptionItem> allOptions;
    private List<OptionItem> filteredOptions;
    private Map<Integer, String> idMap;
    boolean flag;


    // don't need EditViewModel right now, but feel free to add it later if we need to addPropertyChangeListener(this)
    public SearchView(SearchViewModel searchViewModel,
                      CreateNoteController createNoteController,
                      SearchController searchController,
                      RetrieveController retrieveController) throws IOException {

        // Initialization of instance variables
        this.searchViewModel = searchViewModel;
        this.createNoteController = createNoteController;
        this.searchController = searchController;
        this.retrieveController = retrieveController;

        searchViewModel.addPropertyChangeListener(this);


        // ==== RETRIEVE LIST OF NOTES ====
        allOptions = new ArrayList<>();
        filteredOptions = new ArrayList<>();
        idMap = new HashMap<>();
        optionsList = new JList<>();
        // ================================

        // ==== MAKING BUTTONS/ LABELS ====
        // JPanel for buttons

        JPanel buttons = new JPanel();
        buttons.setLayout(null);

        // Main title label
        this.homeTitle = new JLabel("NoteNinjas                                                    ");
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

        // Set layout for the main panel
        this.setLayout(new BorderLayout());

        // Add components to the main panel
        this.add(homeTitle);
        this.add(buttons);

        // Styling for UI elements

        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        flag = true;
        this.propertyUpdate();
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterOptions();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterOptions();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterOptions();
            }
        });

        optionsList = new JList<>(filteredOptions.toArray(new OptionItem[0]));
        optionsList.setFont(new Font("Arial", Font.PLAIN, 16));
        optionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        optionsList.setPreferredSize(new Dimension(685, 500));

        JScrollPane scrollPane = new JScrollPane(optionsList);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        setLayout(new GridBagLayout());

        // Create GridBagConstraints for left-aligning components
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 10, 10, 10); // Add some padding

        // Add the search field to the left
        add(searchField, gbc);

        gbc.gridy = 3;
        // Add the scroll pane to the right
        add(scrollPane, gbc);

        optionsList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                OptionItem selectedOption = optionsList.getSelectedValue();
                if (selectedOption != null && selectedOption.getId() != -1) {
                    int selectedId = selectedOption.getId();
//                    System.out.println("Selected ID: " + selectedId);
                    try {
                        searchController.execute(selectedId);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        searchField.setPreferredSize(new Dimension(700, 40));

        // Initial filter to show all options
        filterOptions();

        // Styling title
        Font largerFont = homeTitle.getFont().deriveFont(Font.ITALIC, 40);
        homeTitle.setFont(largerFont);
//        homeTitle.setBounds(200, 150, 200, 100);

        // Styling first button (Create Note)
        Font newButtonFont = createNote.getFont().deriveFont(Font.PLAIN, 18);
        createNote.setFont(newButtonFont);
//        createNote.setBounds(200, 240, 180, 40);

        gbc.gridy = 0; // Set the gridy for the additional components
        add(homeTitle, gbc);

        gbc.gridy = 1; // Increment gridy for the next component
        add(createNote, gbc);

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

        this.propertyUpdate();
    }

    private void propertyUpdate() {
        retrieveController.execute();
        idMap = searchViewModel.getState().getNotes();
        updateOptions();
    }


    private void updateOptions() {
        allOptions = new ArrayList<>(); // reset options
        for (Map.Entry<Integer, String> entry : idMap.entrySet()) {
            addOption(entry.getKey(), entry.getValue());
        }
        filterOptions();
    }


    private void addOption(int id, String name) {
        OptionItem optionItem = new OptionItem(id, name);
        allOptions.add(optionItem);
    }

    private void filterOptions() {
        String searchTerm = searchField.getText().toLowerCase();
        filteredOptions.clear();

        for (OptionItem option : allOptions) {
            if (option.getName().toLowerCase().contains(searchTerm)) {
                filteredOptions.add(option);
            }
        }

        optionsList.setListData(filteredOptions.toArray(new OptionItem[0]));
    }

    private static class OptionItem {
        private final int id;
        private final String name;

        public OptionItem(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            OptionItem that = (OptionItem) obj;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
