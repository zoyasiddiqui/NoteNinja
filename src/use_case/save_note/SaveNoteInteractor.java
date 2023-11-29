package use_case.save_note;

import data_access.NoteDataAccessObject;
import entity.Note.Note;
import entity.Note.NoteFactory;
import interface_adapter.edit_note.EditNotePresenter;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;

import java.io.IOException;

public class SaveNoteInteractor implements SaveNoteInputBoundary{

    private final EditNoteDataAccessInterface editNoteDataAccessInterface;
    private final CreateNoteDataAccessInterface createNoteDataAccessInterface;
    private final NoteFactory noteFactory;

    public SaveNoteInteractor(EditNoteDataAccessInterface editNoteDataAccessInterface,
                              CreateNoteDataAccessInterface createNoteDataAccessInterface,
                              NoteFactory noteFactory) {
        this.editNoteDataAccessInterface = editNoteDataAccessInterface;
        this.createNoteDataAccessInterface = createNoteDataAccessInterface;
        this.noteFactory = noteFactory;
    }

    @Override
    public void execute(SaveNoteInputData saveNoteInputData) throws IOException {
        // create a note entity using the InputData
        int noteID = saveNoteInputData.getNoteID();
        String noteText = saveNoteInputData.getNoteText();
        String noteTitle = saveNoteInputData.getNoteTitle();

        if (editNoteDataAccessInterface.existsByID(noteID)) { // note already exists
            //TODO: delete once done testing!
            System.out.println("got note with id "+noteID);

            editNoteDataAccessInterface.updateNote(noteID, noteText, noteTitle);

            //TODO: delete once done testing!
            Note curNote = editNoteDataAccessInterface.getNoteById(noteID);
            System.out.println(curNote.getText());

        } else { // else create a new note
            Note note = noteFactory.create(noteTitle, noteText);
            createNoteDataAccessInterface.create(note);
            editNoteDataAccessInterface.updateNote(note.getID(), noteText, note.getName());

            //TODO: delete once done testing!
            System.out.println(note.getText());
        }

    }
}