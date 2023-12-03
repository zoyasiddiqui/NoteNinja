package use_case.rename_note;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RenameNoteOutputDataTest {

    @Test
    void testGetTitle() {
        // Create an instance of RenameNoteOutputData with a title
        RenameNoteOutputData renameNoteOutputData = new RenameNoteOutputData("New Note Title");

        // Use assertEquals to verify that the getTitle method returns the expected title
        assertEquals("New Note Title", renameNoteOutputData.getTitle());

    }

}