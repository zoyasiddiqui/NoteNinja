package entity.Note;

import entity.Tag.Tag;

import java.util.List;

class CommonNote implements Note {
    private String name;
    private List<Tag> tags;
    private List<String> text;

    public CommonNote(String name, List<Tag> tags, List<String> text) {
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
    public void setText(List<String> text) {
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
    public List<String> getText() {
        return this.text;
    }
}