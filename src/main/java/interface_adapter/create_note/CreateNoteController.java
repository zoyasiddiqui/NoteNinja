package interface_adapter.create_note;
import entity.Note.Note;
import use_case.create_note.CreateNoteInputBoundary;
import use_case.create_note.CreateNoteInputData;
import use_case.create_note.CreateNoteInteractor;

import java.io.IOException;

public class CreateNoteController{
    final CreateNoteInputBoundary createNoteInteractor;

    public CreateNoteController(CreateNoteInputBoundary createNoteInteractor) {
        this.createNoteInteractor = createNoteInteractor;
    }

    public void execute(String name) throws IOException {
        CreateNoteInputData createNoteInputData = new CreateNoteInputData(name);
        this.createNoteInteractor.execute(createNoteInputData);
    }
}