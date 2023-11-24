package entity.Note;

import javax.swing.text.html.HTML;
import java.util.List;

public class CommonNoteFactory implements NoteFactory{

    @Override
    public Note create(String name, String text, String ID) {
        return new CommonNote(name, text, ID);
    }

}