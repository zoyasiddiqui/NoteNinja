// Package declaration for the NoteFactory interface within the entity.Note package
package entity.Note;

// Import statement(s) if any

// Interface declaration for the NoteFactory interface
public interface NoteFactory {

    // Method signature for creating a new Note instance
    // Takes name, text, and NoteID as parameters
    Note create(String name, String text, int NoteID);

}
