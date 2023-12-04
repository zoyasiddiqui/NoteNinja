package use_case.create_note;

import entity.Note.Note;
import entity.Note.NoteFactory;
import org.junit.jupiter.api.Test;
import use_case.edit_note.EditNoteOutputData;
import use_case.search_notes.SearchOutputBoundary;

import java.io.IOException;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CreateNoteInteractorTest {

    @Test
    void testExecute_SuccessfulNoteCreation() throws IOException {

    }

    @Test
    void testExecute_FailedNoteCreation() {

    }
}
