package entity;

public interface NoteFactory {

    void create(String name, List<Tag> tags, List<String> text);

}