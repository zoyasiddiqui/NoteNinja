package entity.Note;

import entity.Tag.Tag;
import javax.swing.text.html.HTML;
import java.util.List;

public class CommonNoteFactory implements NoteFactory{

    @Override
    public Note create(String name, List<Tag> tags, List<String> text) {
        // add implementation to actually create the note
        return new CommonNote(name, tags, text);
    }

}