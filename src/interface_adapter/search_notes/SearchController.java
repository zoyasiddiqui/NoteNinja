package interface_adapter.search_notes;

import use_case.create_AI_snippet.CreateAISnippetInputBoundary;
import use_case.search_notes.SearchInputBoundary;

import java.io.IOException;

public class SearchController {

    final SearchInputBoundary searchNotesInteractor;

    public SearchController(SearchInputBoundary searchNotesInteractor) {
        this.searchNotesInteractor = searchNotesInteractor;
    }

    public void execute(String search) throws IOException {
        this.searchNotesInteractor.execute(search);
    }
}