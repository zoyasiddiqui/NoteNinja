package view;

import interface_adapter.edit_note.EditNoteState;
import interface_adapter.edit_note.EditNoteViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditNoteView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "editing";
    private EditNoteViewModel editViewModel;
    final JButton saveNote;
    final JButton deleteNote; // Added the deleteNote button
    private final JTextArea noteTextArea;
    private JButton noteTitleButton;

    public EditNoteView(EditNoteViewModel editViewModel) {
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
        saveNote = new JButton(EditNoteViewModel.SAVE_NOTE_LABEL);
        buttons.add(saveNote);

        // add an ActionListener to the saveNote button (if needed)
        saveNote.addActionListener(this);

        // add the deleteNote button
        deleteNote = new JButton("Delete");
        buttons.add(deleteNote);
        deleteNote.addActionListener(this);

        // Set the layout manager for this JPanel
        setLayout(new BorderLayout());

        // Add the JScrollPane to the center of this JPanel
        add(scrollPane, BorderLayout.CENTER);

        // Add the buttons JPanel to the south of this JPanel
        add(buttons, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveNote) {
            System.out.println("clicked save"); // for debugging delete later
            String noteText = noteTextArea.getText();
            System.out.println(noteText); // for debugging delete later


            // You might want to invoke methods in editViewModel to handle the save action

        } else if (e.getSource() == deleteNote) {
            System.out.println("clicked delete"); // for debugging deleted later
            // Handle deleteNote button click
            // You might want to invoke methods in editViewModel to handle the delete action

        } else if (e.getSource() == noteTitleButton) {
            System.out.println("bars...?");
            String newTitle = JOptionPane.showInputDialog(this, "Enter a new title");
            if (newTitle != null) {
                System.out.println(newTitle);
            }
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property changes if needed


        // === Creating Title Button ===
        // we do this in propertyChange to update the title after loading in the note
        EditNoteState editState = this.editViewModel.getState();
        String noteTitle = editState.getNoteTitle();

        noteTitleButton = new JButton(noteTitle);
        noteTitleButton.setFont(new Font("Arial", Font.BOLD, 18));
        noteTitleButton.setBorderPainted(false);
        noteTitleButton.setContentAreaFilled(false);
        noteTitleButton.setFocusPainted(false);
        noteTitleButton.addActionListener(this);

        // add the title button to the north of this JPanel
        add(noteTitleButton, BorderLayout.NORTH);

        // add the title label to the north of this JPanel
        add(noteTitleButton, BorderLayout.NORTH);
        // == Created Title Button ===

    }
}