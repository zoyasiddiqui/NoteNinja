public interface SearchOutputBoundary {

    void prepareSuccessView(SearchOutputData usersDeleted);

    void prepareFailView(String errormessage);

}