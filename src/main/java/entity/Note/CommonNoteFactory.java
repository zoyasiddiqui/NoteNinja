// Package declaration for the CommonNoteFactory class within the entity.Note package
package entity.Note;

// Import statement(s) if any

// Class declaration for the CommonNoteFactory class implementing the NoteFactory interface
public class CommonNoteFactory implements NoteFactory {

    // Implementation of the create method from the NoteFactory interface
    @Override
    public Note create(String name, String text, int noteID) {
        // Log the noteID to the console (for demonstration purposes)
        System.out.println(noteID);

        // Create and return a new instance of CommonNote with the provided parameters
        return new CommonNote(name, text, noteID);
    }
}
