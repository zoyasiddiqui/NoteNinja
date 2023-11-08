package entity.Note;

import entity.Tag.Tag;

import javax.swing.text.html.HTML;
import java.util.List;

public interface NoteFactory {

    void create(String name, List<Tag> tags, List<String> text);

}