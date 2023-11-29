package entity.Note;

import java.util.List;

public interface Note {

    void setName(String title);
    void setText(String text);
    void setID(int num);
    String getName();
    String getText();
    int getID();
}