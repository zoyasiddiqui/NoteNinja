package use_case.delete_note;

import entity.Note.Note;

import java.io.IOException;

public interface DeleteNoteDataAccessInterface {

    void delete(Note note) throws IOException;

}