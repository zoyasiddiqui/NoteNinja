package data_access;

import entity.Note.Note;
import entity.Note.NoteFactory;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.search_notes.SearchNotesAccessInterface;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class EditNoteDataAccessObject implements CreateNoteDataAccessInterface, EditNoteDataAccessInterface, DeleteNoteDataAccessInterface, SearchNotesAccessInterface {

    private static List<Note> notes = new ArrayList<Note>();
    private String currentText;
    private NoteFactory noteFactory;
    private String url = "https://api.apispreadsheets.com/data/9pYIi0HNV5wCWDYX/";

    public EditNoteDataAccessObject() {}

    public List<Note> getNotes() {
        return this.notes;
    }
    @Override
    public String getCurrentText() {return this.currentText;}

    @Override
    public void setCurrentText(String text) {
        this.currentText = text;
    }

    @Override
    public void save(Note note) throws IOException {

        // create a new note object + save it to my list of notes
        currentText = note.getText();

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json");
        //FIGURE OUT HOW TO WRITE CORRECT QUERY!
        String query = "select * from 9pYIi0HNV5wCWDYX where Note Name='Note Content'";
        String body = "{\"data\": {\"Name\": \"\", \"ID\":\"\", \"Content\":\"New note content\"} \"query\":"+query+"}";
        connection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(body);
        writer.flush();
        writer.close();

        notes.add(note);
        for (Note n: notes) {
            System.out.println(n);
        }
    }


    @Override
    public void delete(Note note) throws IOException {
        String noteId = note.getID(); // Assuming you have a method to get the note ID
        String query = "DELETE FROM 9pYIi0HNV5wCWDYX WHERE ID='" + noteId + "'";
        sendDeleteRequest(query);

        //REMOVE FROM LIST OF NOTES!
    }

    // TODO: figure out how to do this
    @Override
    public boolean existsByID(String noteID) {
        return false;
    }

    // TODO: figure out how to do this
    @Override
    public void updateNote(String noteID, String noteText, String noteTitle) {

    }

    @Override
    public Note getNoteById(List<Note> notes, String noteId) {
        for (Note note : notes) {
            if (note.getID().equals(noteId)) {
                return note;
            }
        }
        return null; // Return null if no note with the specified ID is found
    }

    // Helper method to send a delete request to the specified URL
    private void sendDeleteRequest(String query) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-type", "application/json");

        // Constructing the body of the delete request
        String body = "{\"query\": \"" + query + "\"}";

        connection.setDoOutput(true);
        try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream())) {
            writer.write(body);
        }
    }

    @Override
    public void findByTitle(String noteTitle) {
        
    }
}
