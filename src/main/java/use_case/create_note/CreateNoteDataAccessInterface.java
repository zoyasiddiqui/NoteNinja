package use_case.create_note;

import entity.Note.Note;

import java.io.IOException;

public interface CreateNoteDataAccessInterface {

    void create(Note note) throws IOException;

    int getNoteCount();
}