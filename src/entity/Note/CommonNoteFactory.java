package entity.Note;

import javax.swing.text.html.HTML;
import java.util.List;

public class CommonNoteFactory implements NoteFactory{

    private static int noteID = 0;

    @Override
    public Note create(String name, String text) {
        noteID += 1;
        return new CommonNote(name, text, noteID);
    }

}