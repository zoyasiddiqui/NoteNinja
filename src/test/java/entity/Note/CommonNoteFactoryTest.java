package entity.Note;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonNoteFactoryTest {

    @Test
    void testCreate() {
        // Arrange
        CommonNoteFactory commonNoteFactory = new CommonNoteFactory();
        String name = "Test Note";
        String text = "Sample text";
        int noteID = 123;

        // Act
        Note createdNote = commonNoteFactory.create(name, text, noteID);

        // Assert
        // Verify that the create method returns a non-null instance of CommonNote
        assertNotNull(createdNote);

        // Verify that the created note has the correct properties
        assertEquals(name, createdNote.getName());
        assertEquals(text, createdNote.getText());
        assertEquals(noteID, createdNote.getID());
    }
}