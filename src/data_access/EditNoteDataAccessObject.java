package data_access;

import entity.Note.Note;
import entity.Note.NoteFactory;
import entity.Tag.CommonTag;
import entity.Tag.Tag;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.search_notes.SearchNotesAccessInterface;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EditNoteDataAccessObject implements CreateNoteDataAccessInterface, SearchNotesAccessInterface, EditNoteDataAccessInterface {
    private final File noteFile;
    private String noteName;
    private Map<String, Tag> tags = new HashMap<>();
    private Map<String, Note> notes = new HashMap<>();
    private final NoteFactory noteFactory;
    public EditNoteDataAccessObject(String path, NoteFactory noteFactory, String noteName) {
        this.noteFactory = noteFactory;
        this.noteName = noteName;

        //create note object to put all text in
        this.noteFile = new File(path);

        //create initial tag
        Tag nameTag = new CommonTag(this.noteName);
        this.tags.put(this.noteName, nameTag);

        ArrayList<Tag> tagList = new ArrayList<Tag>();
        tagList.add(nameTag);
        ArrayList<String> text = new ArrayList<String>();
        this.notes.put(this.noteName, this.noteFactory.create(this.noteName, tagList, text));
    }

    @Override
    public void save(Note note) throws IOException {
        //note that we update all three attributes of our note object

        BufferedWriter writer = new BufferedWriter(new FileWriter(this.noteFile));

        //update our name
        this.noteName = note.getName();
        writer.write(this.noteName);
        writer.newLine();

        //update our list of tags
        for (Tag tag : note.getTags()) {
            this.tags.put(tag.getAttribute(), tag);
        }
        //update our text
        for (String line : note.getText()) {
            writer.write(line);
            writer.newLine();
        }

        writer.close();
    }

    @Override
    public void findByTag(String tagName) {

    }
}