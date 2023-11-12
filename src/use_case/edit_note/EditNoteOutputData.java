package use_case.edit_note;

import entity.Tag.Tag;

import java.util.List;

public class EditNoteOutputData {

    private String title;
    private List<Tag> tags;
    private List<String> text;

    public EditNoteOutputData(String title, List<Tag> tags, List<String> text) {
        this.title = title;
        this.tags = tags;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public List<String> getText() {
        return this.text;
    }

}