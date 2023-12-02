package use_case.create_note;

import entity.Note.Note;

import java.io.IOException;

public interface CreateNoteInputBoundary {

    void execute(CreateNoteInputData createNoteInputData) throws IOException;

}