package entity.Note;

public class CommonNoteFactory implements NoteFactory{

    private static int noteID = -1;

    @Override
    public Note create(String name, String text) {
        noteID += 1;
        System.out.println(noteID);
        return new CommonNote(name, text, noteID);
    }

}