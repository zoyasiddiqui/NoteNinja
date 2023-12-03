// Package declaration indicating the location of the class within the project structure
package use_case.rename_note;

// Definition of the RenameNoteOutputData class
public class RenameNoteOutputData {

    // Package-private instance variable to store the title
    String title;

    // Constructor for initializing the RenameNoteOutputData object with a title
    public RenameNoteOutputData(String title) {
        this.title = title;
    }

    // Getter method to retrieve the title
    public String getTitle() {
        return title;
    }
}
