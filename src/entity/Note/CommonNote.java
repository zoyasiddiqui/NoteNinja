package entity.Note;

import entity.Tag.Tag;

import java.util.List;

class CommonNote implements Note {
    private String name;


    @Override
    public void setName(String title) {

    }

    @Override
    public void setTags(List<Tag> tags) {

    }


    @Override
    public void setText(List<String> text) {

    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Tag> getTags() {
        return null;
    }

    @Override
    public List<String> getText() {
        return null;
    }
}