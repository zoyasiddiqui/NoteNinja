package entity.Note;

import entity.Tag.Tag;

import java.util.List;

public interface Note {

    void setName(String title);
    void setTags(List<Tag> tags);
    void setText(List<String> text);
    void save();
    void delete();

    String getName();
    List<Tag> getTags();
    List<String> getText();
    String getId();
}