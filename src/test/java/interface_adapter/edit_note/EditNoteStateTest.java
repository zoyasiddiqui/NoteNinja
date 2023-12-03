package interface_adapter.edit_note;

import interface_adapter.edit_note.EditNoteState;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EditNoteStateTest {

    @Test
    void testDefaultConstructor() {
        // Arrange
        EditNoteState state = new EditNoteState();

        // Act & Assert
        // Verify that default values are initialized
        assertEquals(null, state.getNoteTitle());
        assertEquals(null, state.getNoteText());
        assertEquals(0, state.getNoteID());
    }

    @Test
    void testCopyConstructor() {
        // Arrange
        EditNoteState originalState = new EditNoteState();
        originalState.setNoteTitle("Original Title");
        originalState.setNoteText("Original Text");
        originalState.setNoteID(42);

        // Act
        EditNoteState copiedState = new EditNoteState(originalState);

        // Assert
        // Verify that the copied state has the same values as the original state
        assertEquals("Original Title", copiedState.getNoteTitle());
        assertEquals("Original Text", copiedState.getNoteText());
        assertEquals(42, copiedState.getNoteID());
    }

    @Test
    void testSettersAndGetters() {
        // Arrange
        EditNoteState state = new EditNoteState();

        // Act
        state.setNoteTitle("New Title");
        state.setNoteText("New Text");
        state.setNoteID(123);

        // Assert
        // Verify that setters correctly update values and getters retrieve the updated values
        assertEquals("New Title", state.getNoteTitle());
        assertEquals("New Text", state.getNoteText());
        assertEquals(123, state.getNoteID());
    }
}
