package use_case.search_notes;

public interface SearchOutputBoundary {

    void prepareSuccessView(SearchOutputData usersDeleted);

    void prepareFailView(String errormessage);

}