package data_access;

import entity.Note.CommonNoteFactory;
import entity.Note.Note;
import entity.Note.NoteFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class NoteDataAccessObjectTest {

    private NoteDataAccessObject noteDAO;

    @BeforeEach
    void setUp() {
        noteDAO = new NoteDataAccessObject();
    }

    @Test
    void createNoteAndCheckIfExists() throws IOException {
        // Given
        NoteFactory noteFactory = new CommonNoteFactory();
        Note note = noteFactory.create("Test Note", "This is a test.", 1);

        // When
        noteDAO.create(note);

        // Then
        assertTrue(noteDAO.existsByID(note.getID()));
    }

    @Test
    void deleteNoteAndCheckIfNotExists() throws IOException {
        // Given
        NoteFactory noteFactory = new CommonNoteFactory();
        Note note = noteFactory.create("Test Note", "This is a test.", 2);

        // When
        noteDAO.create(note);
        noteDAO.delete(note);

        // Then
        assertFalse(noteDAO.existsByID(note.getID()));
    }

    @Test
    void updateNoteAndCheckIfUpdated() throws IOException {
        // Given
        NoteFactory noteFactory = new CommonNoteFactory();
        Note note = noteFactory.create("Test Note", "This is a test.", 3);

        // When
        noteDAO.create(note);
        noteDAO.updateNote(note.getID(), "Updated text.", "Updated Title");

    }

    @Test
    void searchNoteByTitle() throws IOException {
        // Given
        NoteFactory noteFactory = new CommonNoteFactory();
        Note note = noteFactory.create("Search Test", "This is a search test.", 4);

        // When
        noteDAO.create(note);


    }

}