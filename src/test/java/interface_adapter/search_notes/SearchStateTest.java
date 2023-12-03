package interface_adapter.search_notes;

import entity.Note.Note;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SearchStateTest {

    @Test
    void testDefaultConstructorAndGetNotes() {
        // Arrange and Act
        SearchState searchState = new SearchState();

        // Assert
        // Verify that the list of notes is not null by default
        assertNotNull(searchState.getNotes());
        // Verify that the list of notes is empty by default
        assertEquals(0, searchState.getNotes().size());
    }

    @Test
    void testSetterAndGetter() {
        // Arrange
        SearchState searchState = new SearchState();
        List<Note> notes = new ArrayList<>();
        notes.add(Mockito.mock(Note.class)); // Using a mock for testing purposes

        // Act
        searchState.setNotes(notes);

        // Assert
        // Verify that the getter returns the same list of notes that was set
        assertEquals(notes, searchState.getNotes());
    }
}
