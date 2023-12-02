// Package declaration
package view;

// Import statements for various classes and interfaces
import interface_adapter.back_menu.BackMenuController;
import interface_adapter.create_AI_snippet.CreateAISnippetController;
import interface_adapter.create_code_snippet.CreateCodeSnippetController;
import interface_adapter.delete_note.DeleteNoteController;
import interface_adapter.edit_note.EditNoteState;
import interface_adapter.edit_note.EditNoteViewModel;
import interface_adapter.edit_note.RenameNoteController;
import interface_adapter.save_note.SaveController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

// Class declaration for EditNoteView extending JPanel and implementing ActionListener and PropertyChangeListener
public class EditNoteView extends JPanel implements ActionListener, PropertyChangeListener {
    // Constants for viewName and button labels
    public final String viewName = "editing";

    // Instance variables for controllers, models, and UI elements
    private final EditNoteViewModel editViewModel;
    private final RenameNoteController renameNoteController;
    private final SaveController saveNoteController;
    private final BackMenuController backMenuController;
    private final CreateAISnippetController createAISnippetController;
    private final DeleteNoteController deleteNoteController;

    // Buttons for various actions
    final JButton saveNote;
    final JButton deleteNote; // Added the deleteNote button
    final JButton backMenu;
    final JButton createAISnippet;
    final JButton createCodeSnippet;
    private final JTextArea noteTextArea;
    private final CreateCodeSnippetController createCodeSnippetController;
    private JButton noteTitleButton;

    // Constructor for EditNoteView
    public EditNoteView(EditNoteViewModel editViewModel,
                        RenameNoteController renameNoteController,
                        SaveController saveNoteController,
                        BackMenuController backMenuController,
                        DeleteNoteController deleteNoteController,
                        CreateAISnippetController createAISnippetController,
                        CreateCodeSnippetController createCodeSnippetController) {
        // Initialization of instance variables
        this.editViewModel = editViewModel;
        this.saveNoteController = saveNoteController;
        this.deleteNoteController = deleteNoteController;
        this.createAISnippetController = createAISnippetController;
        this.createCodeSnippetController = createCodeSnippetController;
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

        createAISnippet = new JButton(EditNoteViewModel.AI_SNIPPET_LABEL);
        buttons.add(createAISnippet);
        createCodeSnippet = new JButton(EditNoteViewModel.CODE_SNIPPET_LABEL);
        buttons.add(createCodeSnippet);
        saveNote = new JButton(EditNoteViewModel.SAVE_NOTE_LABEL);
        buttons.add(saveNote);
        deleteNote = new JButton(EditNoteViewModel.DELETE_NOTE_LABEL);
        buttons.add(deleteNote);
        backMenu = new JButton(EditNoteViewModel.BACK_MENU_LABEL);
        buttons.add(backMenu);

        noteTitleButton = new JButton(EditNoteViewModel.DEFAULT_NOTE_TITLE);
        noteTitleButton.setFont(new Font("Arial", Font.BOLD, 18));
        noteTitleButton.setBorderPainted(false);
        noteTitleButton.setContentAreaFilled(false);
        noteTitleButton.setFocusPainted(false);
        noteTitleButton.addActionListener(this);

        // TODO: Add a general keyTyped event to the noteTextArea which always updates noteState in live
        // TODO: this way we wont need to call noteTextArea.getText() every time, we just take from the NoteState

        // ===== SAVE NOTE LISTENER =====
        saveNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(saveNote)) {
                            EditNoteState editNoteState = editViewModel.getState();
                            try {
                                EditNoteView.this.saveNoteController.execute(editNoteState.getNoteTitle(),
                                        editNoteState.getNoteText(),
                                        editNoteState.getNoteID());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
                            backMenuController.execute();
                        }
                    }
                }
        );
        // ==============================

        // ====== AI SNIPPET LISTENER =======
        createAISnippet.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String prompt = JOptionPane.showInputDialog(EditNoteView.this, "Enter AI prompt");
                        EditNoteState editNoteState = editViewModel.getState();
                        if (prompt != null) {
                            try {
                                createAISnippetController.execute(
                                        prompt,
                                        editNoteState.getNoteText(),
                                        editNoteState.getNoteTitle(),
                                        editNoteState.getNoteID());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );
        // ==============================

        // ====== CODE SNIPPET LISTENER =======
        createCodeSnippet.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // special input box for entering code
                        JTextArea codeArea = new JTextArea(20, 40);
                        JScrollPane scrollPane = new JScrollPane(codeArea);

                        int result = JOptionPane.showConfirmDialog(
                                EditNoteView.this,
                                scrollPane,
                                "Enter Code",
                                JOptionPane.OK_CANCEL_OPTION,
                                JOptionPane.PLAIN_MESSAGE
                        );

                        if (result == JOptionPane.OK_OPTION) {
                            String code = codeArea.getText();
                            EditNoteState editNoteState = editViewModel.getState();
                            try {
                                createCodeSnippetController.execute(
                                        code,
                                        editNoteState.getNoteText(),
                                        editNoteState.getNoteTitle(),
                                        editNoteState.getNoteID());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );
        // ==============================

        // ====== RENAME LISTENER =======
        noteTitleButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(noteTitleButton)) {
                            String newTitle = JOptionPane.showInputDialog("Enter a new title");
                            EditNoteState editNoteState = editViewModel.getState();
                            if (newTitle != null) {
                                try {
                                    renameNoteController.execute(
                                            editNoteState.getNoteID(),
                                            newTitle,
                                            editNoteState.getNoteText());

                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }
                }
        );
        // ==============================

        // ==== DELETE NOTE LISTENER ====
        deleteNote.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(deleteNote)) {
                            EditNoteState editState = editViewModel.getState();
                            int noteID = editState.getNoteID();
                            try {
                                deleteNoteController.execute(noteID);
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );
        // ==============================

        // Additional listeners and setup code if needed

        noteTitleButton.addActionListener(this);
        saveNote.addActionListener(this);
        backMenu.addActionListener(this);
        deleteNote.addActionListener(this);
        createAISnippet.addActionListener(this);
        createCodeSnippet.addActionListener(this);

        // Set the layout manager for this JPanel
        setLayout(new BorderLayout());

        // Add the JScrollPane to the center of this JPanel
        add(scrollPane, BorderLayout.CENTER);

        // Add the buttons JPanel to the south of this JPanel
        this.add(buttons, BorderLayout.SOUTH);
        add(noteTitleButton, BorderLayout.NORTH);// add the title button to the north of this JPanel

        // ===== KEY PRESS LISTENER =====
        noteTextArea.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        EditNoteState currentState = editViewModel.getState();
                        String text = noteTextArea.getText() + e.getKeyChar();
                        currentState.setNoteText(text);
                        editViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });
        // ==============================
    }

    // ActionListener method implementation
    @Override
    public void actionPerformed(ActionEvent e) {
        // Empty method required due to interface implementation
        // Actual handling is done within individual button listeners
    }

    // PropertyChangeListener method implementation
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Handle property changes if needed, updating UI elements based on the editViewModel state
        noteTitleButton.setText(editViewModel.getState().getNoteTitle());
        noteTextArea.setText(editViewModel.getState().getNoteText());
    }
}
