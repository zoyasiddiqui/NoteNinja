package app;

import interface_adapter.edit_note.EditViewModel;
import view.NoteEditorView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        // Create an instance of EditViewModel (assuming you have implemented it)
        EditViewModel editViewModel = new EditViewModel();

        // Create an instance of NoteEditorView with the EditViewModel
        NoteEditorView noteEditorView = new NoteEditorView(editViewModel);

        // Set up the JFrame
        JFrame application = new JFrame("Edit Note Example");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.getContentPane().add(noteEditorView); // Add the NoteEditorView to the JFrame

        // Pack and display the JFrame
        application.pack();
        application.setVisible(true);

    }
}
