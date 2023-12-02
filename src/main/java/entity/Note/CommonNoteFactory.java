package entity.Note;

import javax.swing.text.html.HTML;
import java.util.List;

public class CommonNoteFactory implements NoteFactory{

    @Override
    public Note create(String name, String text, int noteID) {
        System.out.println(noteID);
        return new CommonNote(name, text, noteID);
    }

}