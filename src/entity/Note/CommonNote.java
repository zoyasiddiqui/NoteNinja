package entity.Note;

import java.util.List;

class CommonNote implements Note {
    private String name;
    private String text;
    private String ID;

    public CommonNote(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public void setName(String title) {
        this.name = title;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public void setID(String ID) {
        this.ID = ID;
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
    public String getText() {
        return this.text;
    }

    public String getID() {
        return ID;
    }
}