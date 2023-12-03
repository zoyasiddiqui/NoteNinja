// Package declaration indicating the location of the interface within the project structure
package use_case.search_notes;

// Import statement for the Note entity
import entity.Note.Note;

// Definition of the SearchNotesAccessInterface interface
public interface SearchNotesAccessInterface {

    // Method signature for finding a Note by its title
    Note findByTitle(String noteTitle);

}
