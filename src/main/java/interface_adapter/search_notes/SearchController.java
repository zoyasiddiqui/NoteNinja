// Package declaration
package interface_adapter.search_notes;

// Import statement for SearchInputBoundary
import use_case.search_notes.SearchInputBoundary;

// IOException import for exception handling
import java.io.IOException;

// Class declaration for SearchController
public class SearchController {
    // Instance variable for SearchInputBoundary
    final SearchInputBoundary searchNotesInteractor;

    // Constructor for SearchController
    public SearchController(SearchInputBoundary searchNotesInteractor) {
        this.searchNotesInteractor = searchNotesInteractor;
    }

    // Method to execute search for notes
    public void execute(String search) throws IOException {
        // Execute the search operation using SearchInputBoundary
        this.searchNotesInteractor.execute(search);
    }
}
