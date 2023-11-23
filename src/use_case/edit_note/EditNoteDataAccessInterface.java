package use_case.edit_note;

import entity.Note.Note;

import java.io.IOException;

public interface EditNoteDataAccessInterface {
    void save (Note note) throws IOException;

    Note getNoteById(String noteId);

    void delete(Note note) throws IOException;
}