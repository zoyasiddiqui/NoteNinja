package use_case.create_note;

import entity.Note.Note;

public interface CreateNoteDataAccessInterface {

    void save(Note note);

}