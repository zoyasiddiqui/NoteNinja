package view;

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
    JLabel noteTitle;

    final JButton saveNote;

    public NoteEditorView(EditViewModel editViewModel) {
        this.editViewModel = editViewModel;
        this.editViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Editing Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel noteTitleInfo = new JLabel("Currently logged in: ");
        noteTitle = new JLabel();

        JPanel buttons = new JPanel();
        saveNote = new JButton(editViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(saveNote);

        saveNote.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(noteTitleInfo);
        this.add(noteTitle);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}