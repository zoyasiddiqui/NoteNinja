package use_case.edit_note;

import entity.Note.Note;

import java.io.IOException;
import java.util.List;

public interface EditNoteDataAccessInterface {

    Note getNoteById(int noteId);

    boolean existsByID(int noteID);

    void updateNote(int noteID, String noteText, String noteTitle) throws IOException;

    String getCurrentText();
  
    void setCurrentText(String text);

    int getNoteCount();
    void incrementNoteCount();
}