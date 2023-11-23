package use_case.edit_note;

import entity.Note.Note;

import java.io.IOException;

public interface EditNoteDataAccessInterface {
    void save (Note note) throws IOException;
}