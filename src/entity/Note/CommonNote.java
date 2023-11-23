package entity.Note;

import entity.Tag.Tag;

import java.util.List;

class CommonNote implements Note {
    private String name;
    private List<Tag> tags;
    private String text;

    public CommonNote(String name, List<Tag> tags, String text) {
        this.name = name;
        this.tags = tags;
        this.text = text;
    }

    @Override
    public void setName(String title) {
        this.name = title;
    }

    @Override
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }


    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public List<Tag> getTags() {
        return this.tags;
    }

    @Override
    public String getText() {
        return this.text;
    }
}