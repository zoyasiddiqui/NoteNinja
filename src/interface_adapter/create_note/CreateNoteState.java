package interface_adapter.create_note;

import entity.Tag.Tag;

import java.util.List;

public class CreateNoteState {
    private String title;
    private List<Tag> tags;
    private List<String> text;

    public CreateNoteState() {}
    public CreateNoteState(CreateNoteState copy) {
        this.title = copy.title;
        this.tags = copy.tags;
        this.text = copy.text;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<String> getText() {
        return this.text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

}