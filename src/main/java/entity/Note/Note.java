// Package declaration for the Note interface within the entity.Note package
package entity.Note;

// Import statement(s) if any

// Interface declaration for the Note interface
public interface Note {

    // Method to set the name/title of the note
    void setName(String title);

    // Method to set the text content of the note
    void setText(String text);

    // Method to set the ID of the note
    void setID(int num);

    // Method to get the name/title of the note
    String getName();

    // Method to get the text content of the note
    String getText();

    // Method to get the ID of the note
    int getID();
}
