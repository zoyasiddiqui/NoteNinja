package use_case.edit_note;

import entity.Note.Note;

import java.util.List;

public class EditNoteOutputData {

    private Note note;
    private String title;
    private String text;

    public EditNoteOutputData(Note note) {
        this.note = note;
        this.title = note.getName();
        this.text = note.getText();
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {return this.text;}

    public int getID() {
        return this.note.getID();
    }

}