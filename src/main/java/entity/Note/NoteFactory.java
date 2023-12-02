package entity.Note;

public interface NoteFactory {

    Note create(String name, String text);

}