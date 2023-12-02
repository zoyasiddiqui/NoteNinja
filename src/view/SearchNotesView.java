package view;

import interface_adapter.search_notes.SearchController;
import interface_adapter.search_notes.SearchViewModel;
import interface_adapter.switch_to_search.SwitchToSearchController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class SearchNotesView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "search notes";
    private final SearchViewModel searchViewModel;
    private final SearchController searchController;
    private final SwitchToSearchController switchToSearchController;
    private final JTextField searchBar;
    private final JLabel searchTitle;
    private final JButton searchNote;

    public SearchNotesView(SearchViewModel searchViewModel,
                           SearchController searchController,
                           SwitchToSearchController switchToSearchController) {
        this.searchViewModel = searchViewModel;
        this.searchController = searchController;
        this.switchToSearchController = switchToSearchController;
        searchViewModel.addPropertyChangeListener(this);

        // === making buttons and labels ===

        JPanel buttons = new JPanel();
        buttons.setLayout(null);

        //Main title label
        this.searchTitle = new JLabel("Search for Notes");
        searchTitle.setBounds(30, 0, 200, 100);
        Font largerFont = searchTitle.getFont().deriveFont(Font.PLAIN, 30);
        searchTitle.setFont(largerFont);

        //Text area and search note button
        searchBar = new JTextField("Enter search here");
        searchNote = new JButton("Search");
        buttons.add(searchNote);

        searchNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(searchNote)) {
                            String toSearch = searchBar.getText();
                            try {
                                searchController.execute(toSearch);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );
        searchNote.addActionListener(this);

        JScrollPane scrollPane = new JScrollPane();
        this.add(scrollPane);

        this.add(buttons);
        buttons.setVisible(true);

        this.add(searchBar);
        Font searchFont = searchBar.getFont().deriveFont(Font.PLAIN, 20);
        searchBar.setFont(searchFont);
        searchBar.setBorder(new LineBorder(Color.black, 2));
        searchBar.setBounds(50, 200, 500, 50);

        this.setLayout(new BorderLayout());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }
}
