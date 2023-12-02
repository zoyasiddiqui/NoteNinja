package interface_adapter.search_notes;

import use_case.search_notes.SearchOutputBoundary;
import use_case.search_notes.SearchOutputData;

public class SearchPresenter implements SearchOutputBoundary{

    @Override
    public void prepareSuccessView(SearchOutputData usersDeleted) {

    }

    @Override
    public void prepareFailView(String errormessage) {

    }
}