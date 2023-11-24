package entity.Note;

import java.util.List;

public interface Note {

    void setName(String title);
    void setText(String text);
    void setID(String text);
    void save();
    void delete();

    String getName();
    String getText();
    String getID();
}