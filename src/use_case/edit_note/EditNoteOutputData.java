package use_case.edit_note;

import entity.Note.Note;

import java.util.List;

public class EditNoteOutputData {

    private int noteId;
    private String title;
    private String text;

    public EditNoteOutputData(int Id, String title, String text) {
        this.noteId = Id;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getText() {return this.text;}

    public int getID() {
        return this.noteId;
    }

}