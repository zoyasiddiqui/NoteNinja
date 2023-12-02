// Package declaration
package interface_adapter.create_note;

// Import statement for the List class
import java.util.List;

// Class declaration for CreateNoteState
public class CreateNoteState {

    // Private member variables to hold the title and text of the note
    private String title;
    private List<String> text;

    // Default constructor
    public CreateNoteState() {}

    // Copy constructor to create a copy of the state
    public CreateNoteState(CreateNoteState copy) {
        this.title = copy.title;
        this.text = copy.text;
    }

    // Getter method for retrieving the title
    public String getTitle(){
        return this.title;
    }

    // Setter method for setting the title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method for retrieving the text
    public List<String> getText() {
        return this.text;
    }

    // Setter method for setting the text
    public void setText(List<String> text) {
        this.text = text;
    }
}
