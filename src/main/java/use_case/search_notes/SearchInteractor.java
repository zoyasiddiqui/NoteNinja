package use_case.search_notes;

import java.io.IOException;

public class SearchInteractor implements SearchInputBoundary{

    final SearchNotesAccessInterface searchNotesAccessInterface;

    public SearchInteractor(SearchNotesAccessInterface searchNotesAccessInterface) {
        this.searchNotesAccessInterface = searchNotesAccessInterface;
    }

    @Override
    public void execute() throws IOException {

    }
}