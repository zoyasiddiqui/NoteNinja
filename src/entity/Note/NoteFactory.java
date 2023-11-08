package entity.Note;

import javax.swing.text.html.HTML;
import java.util.List;

public interface NoteFactory {

    void create(String name, List<HTML.Tag> tags, List<String> text);

}