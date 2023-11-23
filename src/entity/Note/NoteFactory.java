package entity.Note;

import entity.Tag.Tag;

import javax.swing.text.html.HTML;
import java.util.List;

public interface NoteFactory {

    Note create(String name, List<Tag> tags, String text);

}