package use_case.edit_note;

import entity.Note.Note;

import java.util.List;

public class EditNoteOutputData {

    private Note note;
    private String title;
    private String text;

    public EditNoteOutputData(Note note, String title, String text) {
        this.note = note;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {return this.text;}

}