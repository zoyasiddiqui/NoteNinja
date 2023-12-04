// Package declaration indicating the location of the interface within the project structure
package use_case.search_notes;

import use_case.edit_note.EditNoteOutputData;
import use_case.retrieve.RetrieveOutputData;

// Definition of the SearchOutputBoundary interface
public interface SearchOutputBoundary {

    // Method signature for preparing a success view with search results
    void prepareNewNote(EditNoteOutputData editNoteOutputData);

    // Method signature for preparing a fail view with an error message
    void prepareFailView(String errorMessage);

    void prepareExistingNote(EditNoteOutputData editNoteOutputData);

    void loadOptions(RetrieveOutputData retrieveOutputData);
}
