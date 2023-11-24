package entity.Note;

import javax.swing.text.html.HTML;
import java.util.List;

public interface NoteFactory {

    Note create(String name, String text);

}