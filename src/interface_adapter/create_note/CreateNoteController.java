package interface_adapter.create_note;
import use_case.create_code_snippet.CreateCodeSnippetInputBoundary;
import use_case.create_note.CreateNoteInteractor;

import java.io.IOException;

public class CreateNoteController{
    final CreateNoteInteractor createNoteInteractor;

    public CreateNoteController(CreateNoteInteractor createNoteInteractor) {
        this.createNoteInteractor = createNoteInteractor;
    }

    public void execute(String name) throws IOException {
        this.createNoteInteractor.execute(name);
    }
}