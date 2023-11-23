package data_access;

import entity.Note.Note;
import use_case.create_note.CreateNoteDataAccessInterface;
import use_case.delete_note.DeleteNoteDataAccessInterface;
import use_case.edit_note.EditNoteDataAccessInterface;
import use_case.search_notes.SearchNotesAccessInterface;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class EditNoteDataAccessObject implements CreateNoteDataAccessInterface, EditNoteDataAccessInterface, DeleteNoteDataAccessInterface, SearchNotesAccessInterface {

    String url = "https://api.apispreadsheets.com/data/9pYIi0HNV5wCWDYX/";

    public EditNoteDataAccessObject() {}

    @Override
    public void save(Note note) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json");
        String query = "select * from 9pYIi0HNV5wCWDYX where Note Name='Note Content'";
        String body = "{\"data\": {\"Name\": \"\", \"ID\":\"\", \"Content\":\"New note content\"} \"query\":"+query+"}";
        connection.setDoOutput(true);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(body);
        writer.flush();
        writer.close();
    }

    @Override
    public void delete(Note note) throws IOException {
        // Extracting note information for the deletion
        String noteId = note.getId(); // Assuming you have a method to get the note ID

        // Constructing the delete query based on the provided SQL-like format
        String query = "DELETE FROM 9pYIi0HNV5wCWDYX WHERE ID='" + noteId + "'";

        // Sending the delete request
        sendDeleteRequest(query);
    }

    @Override
    public void findByTag(String tagName) {
        // Your existing findByTag method logic
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
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(body);
        writer.flush();
        writer.close();
    }
}
