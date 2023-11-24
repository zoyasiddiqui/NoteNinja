package view;

import entity.Note.Note;
import interface_adapter.back_menu.BackMenuController;
import interface_adapter.create_AI_snippet.CreateAISnippetController;
import interface_adapter.edit_note.EditNoteState;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.edit_note.RenameNoteController;
import interface_adapter.save_note.SaveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

public class EditNoteView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "editing";
    private final Note note;
    private final EditNoteViewModel editViewModel;
    private final RenameNoteController renameNoteController;
    private final SaveController saveNoteController;
    private final BackMenuController backMenuController;
    private final CreateAISnippetController createAISnippetController;
    final JButton saveNote;
    final JButton deleteNote; // Added the deleteNote button
    final JButton backMenu;
    final JButton createAISnippet;
    private final JTextArea noteTextArea;
    private JButton noteTitleButton;

    public EditNoteView(Note note, EditNoteViewModel editViewModel,
                        RenameNoteController renameNoteController,
                        SaveController saveNoteController,
                        BackMenuController backMenuController, CreateAISnippetController createAISnippetController) {
        this.note = note;
        this.editViewModel = editViewModel;
        this.saveNoteController = saveNoteController;
        this.createAISnippetController = createAISnippetController;
        this.editViewModel.addPropertyChangeListener(this);
        this.renameNoteController = renameNoteController;
        this.backMenuController = backMenuController;

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
        deleteNote = new JButton(EditNoteViewModel.DELETE_NOTE_LABEL);
        buttons.add(deleteNote);
        backMenu = new JButton(EditNoteViewModel.BACK_MENU_LABEL);
        buttons.add(backMenu);
        createAISnippet = new JButton(EditNoteViewModel.AI_SNIPPET_LABEL);
        buttons.add(createAISnippet);


        // ===== SAVE NOTE LISTENER =====
        saveNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(saveNote)) {
//                            EditNoteView.this.saveNoteController.execute();
                            System.out.println("clicked save!!");
                        }
                    }
                }
        );
        // ==============================


        // ======== BACK LISTENER =======
        backMenu.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(backMenu)) {
                            System.out.println("pressed back");
                            backMenuController.execute();
                        }
                    }
                }
        );

        createAISnippet.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String prompt = JOptionPane.showInputDialog(this, "Enter AI prompt");
                        if (prompt != null) {
                            try {
                                createAISnippetController.execute(prompt);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );


        saveNote.addActionListener(this);
        backMenu.addActionListener(this);
        deleteNote.addActionListener(this);
        createAISnippet.addActionListener(this);

        // Set the layout manager for this JPanel
        setLayout(new BorderLayout());

        // Add the JScrollPane to the center of this JPanel
        add(scrollPane, BorderLayout.CENTER);

        // Add the buttons JPanel to the south of this JPanel
        this.add(buttons, BorderLayout.SOUTH);
    }

//    TODO: figure out if we want the code below or not.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveNote) {
//            System.out.println("clicked save"); // for debugging delete later
            String noteText = noteTextArea.getText();
            System.out.println(noteText); // for debugging delete later


            // You might want to invoke methods in editViewModel to handle the save action

        } else if (e.getSource() == deleteNote) {
            System.out.println("clicked delete"); // for debugging deleted later
            // Handle deleteNote button click
            // You might want to invoke methods in editViewModel to handle the delete action

        } else if (e.getSource() == noteTitleButton) {
            String newTitle = JOptionPane.showInputDialog(this, "Enter a new title");
            if (newTitle != null) {
                try {
                    renameNoteController.execute(newTitle);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
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
