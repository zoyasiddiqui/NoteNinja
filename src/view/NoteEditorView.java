package view;

import interface_adapter.edit_note.EditState;
import interface_adapter.edit_note.EditViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class NoteEditorView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "editing";
    private EditViewModel editViewModel;
    // JLabel noteTitle;

    JLabel noteTitle;
    final JButton saveNote;

    public NoteEditorView(EditViewModel editViewModel) {
        this.editViewModel = editViewModel;
        this.editViewModel.addPropertyChangeListener(this);

        JLabel noteTitle = new JLabel();
        noteTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        // not sure if we want this
        // JLabel noteTitleInfo = new JLabel("Editing: ");
        // noteTitle = new JLabel();

        JPanel buttons = new JPanel();
        saveNote = new JButton(editViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(saveNote);

        saveNote.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(noteTitle);
        // this.add(noteTitleInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditState state = (EditState) evt.getNewValue();
        noteTitle.setText("Editing" + state.getNoteTitle());
    }
}