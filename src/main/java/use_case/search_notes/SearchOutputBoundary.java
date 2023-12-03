// Package declaration indicating the location of the interface within the project structure
package use_case.search_notes;

// Definition of the SearchOutputBoundary interface
public interface SearchOutputBoundary {

    // Method signature for preparing a success view with search results
    void prepareSuccessView(SearchOutputData usersDeleted);

    // Method signature for preparing a fail view with an error message
    void prepareFailView(String errorMessage);

}
