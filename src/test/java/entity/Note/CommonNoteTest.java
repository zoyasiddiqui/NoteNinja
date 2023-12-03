package entity.Note;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommonNoteTest {

    @Test
    void testSetNameAndGetTitle() {
        // Arrange
        CommonNote commonNote = new CommonNote("Initial Title", "Note text", 1);
        String newTitle = "Updated Title";

        // Act
        commonNote.setName(newTitle);

        // Assert
        // Verify that getName returns the correct title
        assertEquals(newTitle, commonNote.getName());
    }

    @Test
    void testSetTextAndGetText() {
        // Arrange
        CommonNote commonNote = new CommonNote("Note Title", "Initial text", 1);
        String newText = "Updated text";

        // Act
        commonNote.setText(newText);

        // Assert
        // Verify that getText returns the correct text
        assertEquals(newText, commonNote.getText());
    }

    @Test
    void testSetAndGetID() {
        // Arrange
        CommonNote commonNote = new CommonNote("Note Title", "Note text", 1);
        int newID = 2;

        // Act
        commonNote.setID(newID);

        // Assert
        // Verify that getID returns the correct ID
        assertEquals(newID, commonNote.getID());
    }
}
