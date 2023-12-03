package use_case.delete_note;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteNoteInputDataTest {

    @Test
    void testConstructorAndGetNoteID() {
        // Test data
        int noteID = 123;

        // Create an instance of DeleteNoteInputData using the constructor
        DeleteNoteInputData deleteNoteInputData = new DeleteNoteInputData(noteID);

        // Verify that the note ID is correctly set by the constructor
        assertEquals(noteID, deleteNoteInputData.getNoteID());
    }

    @Test
    void testGetNoteIDWithDifferentValue() {
        // Test data
        int noteID = 123;
        int differentNoteID = 456;

        // Create an instance of DeleteNoteInputData using the constructor
        DeleteNoteInputData deleteNoteInputData = new DeleteNoteInputData(noteID);

        // Verify that the note ID is correctly set by the constructor
        assertEquals(noteID, deleteNoteInputData.getNoteID());

        // Verify that the note ID is not equal to a different value
        assertEquals(differentNoteID != deleteNoteInputData.getNoteID(), true);
    }
}