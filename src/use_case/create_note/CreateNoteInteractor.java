package use_case.create_note;

import data_access.NoteDataAccessObject;
import entity.Note.Note;
import entity.Note.NoteFactory;
import entity.Tag.Tag;

import java.util.ArrayList;
import java.util.List;

public class CreateNoteInteractor implements CreateNoteInputBoundary{

    final NoteFactory noteFactory;
    final NoteDataAccessObject noteDataAccessObject;

    public CreateNoteInteractor(NoteFactory noteFactory, NoteDataAccessObject noteDataAccessObject) {
        this.noteFactory = noteFactory;
        this.noteDataAccessObject = noteDataAccessObject;
    }

    @Override
    public void execute(String name) {
        String noteTitle = "untitled";
        List<Tag> tags = new ArrayList<Tag>();
        List<String> text = new ArrayList<String>();
        Note note = noteFactory.create(noteTitle, tags, text);
        noteDataAccessObject.save(note);
    }
}