// Package declaration for the CommonNote class within the entity.Note package
package entity.Note;

// Import statement(s) if any

// Class declaration for the CommonNote class implementing the Note interface
class CommonNote implements Note {

    // Private fields to store note name, text, and ID
    private String name;
    private String text;
    private int ID;

    // Constructor for creating an instance of CommonNote with initial values
    public CommonNote(String name, String text, int ID) {
        this.name = name;
        this.text = text;
        this.ID = ID;
    }

    // Implementation of the setName method from the Note interface
    @Override
    public void setName(String title) {
        this.name = title;
    }

    // Implementation of the setText method from the Note interface
    @Override
    public void setText(String text) {
        this.text = text;
    }

    // Custom method to set the ID of the note
    public void setID(int ID) {
        this.ID = ID;
    }

    // Implementation of the getName method from the Note interface
    @Override
    public String getName() {
        return this.name;
    }

    // Implementation of the getText method from the Note interface
    @Override
    public String getText() {
        return this.text;
    }

    // Custom method to get the ID of the note
    public int getID() {
        return ID;
    }
}
