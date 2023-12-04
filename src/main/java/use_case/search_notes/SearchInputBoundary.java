// Package declaration indicating the location of the class within the project structure
package use_case.search_notes;

// Import statements for handling IOException, Note entity, and List
import java.io.IOException;

// Definition of the SearchInputBoundary interface
public interface SearchInputBoundary {

    // Method signature for the execute method, which takes a search string and may throw IOException
    void execute(int noteID) throws IOException;
}
