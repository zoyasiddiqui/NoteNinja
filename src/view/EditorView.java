package view;

import interface_adapter.edit_note.EditViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditorView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "editing";
    private EditViewModel editViewModel;
    final JButton saveNote;
    private JTextArea noteTextArea;

    public EditorView(EditViewModel editViewModel) {
        this.editViewModel = editViewModel;
        this.editViewModel.addPropertyChangeListener(this);

        // create a JTextArea for note-taking
        noteTextArea = new JTextArea();
        noteTextArea.setLineWrap(true);
        noteTextArea.setWrapStyleWord(true);

        // create a JScrollPane to allow scrolling if the text is too long
        JScrollPane scrollPane = new JScrollPane(noteTextArea);

        // create a JPanel for buttons
        JPanel buttons = new JPanel();
        saveNote = new JButton(EditViewModel.SAVE_NOTE_LABEL);
        buttons.add(saveNote);

        // Add an ActionListener to the button (if needed)
        saveNote.addActionListener(this);

        // Set the layout manager for this JPanel
        setLayout(new BorderLayout());

        // Add the JScrollPane to the center of this JPanel
        add(scrollPane, BorderLayout.CENTER);

        // Add the buttons JPanel to the south of this JPanel
        add(buttons, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button clicks or perform any necessary actions
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property changes if needed
    }
}
