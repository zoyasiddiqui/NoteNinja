package use_case.edit_note;

import entity.Note.Note;

import java.io.IOException;
import java.util.List;

public interface EditNoteDataAccessInterface {
    void save (Note note) throws IOException;

    Note getNoteById(List<Note> notes, String noteId);

    void delete(Note note) throws IOException;

    String getCurrentText();
    void setCurrentText(String text);
}