// Package declaration indicating the location of the class within the project structure
package use_case.search_notes;

// Import statement for the Note entity and List interface
import entity.Note.Note;
import java.util.List;

// Definition of the SearchOutputData class
public class SearchOutputData {

    // List to store search results of Note entities
    List<Note> notes;

    // Constructor to initialize the SearchOutputData with a list of notes
    public SearchOutputData(List<Note> notes) {
        this.notes = notes;
    }

    // Getter method to retrieve the list of notes
    public List<Note> getNotes() {
        return this.notes;
    }

    // Setter method to update the list of notes
    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

}
