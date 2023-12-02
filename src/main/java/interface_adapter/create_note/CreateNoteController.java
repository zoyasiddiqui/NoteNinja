package interface_adapter.create_note;
import use_case.create_note.CreateNoteInputBoundary;
import use_case.create_note.CreateNoteInputData;

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