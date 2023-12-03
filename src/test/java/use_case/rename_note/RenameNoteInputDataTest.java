package use_case.rename_note;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RenameNoteInputDataTest {

    @Test
    void testGetNoteTitle() {
        // Create an instance of RenameNoteInputData with a sample note title
        RenameNoteInputData renameNoteInputData = new RenameNoteInputData("Sample Note Title");

        // Use assertEquals to check that the getNoteTitle method returns the expected value
        assertEquals("Sample Note Title", renameNoteInputData.getNoteTitle());
    }

    // Add more test cases as needed...
}