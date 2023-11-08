package interface_adapter.search_notes;

public class SearchState {
    private String searchBar = "";

    public SearchState(SearchState copy) {
        this.searchBar = copy.searchBar;
    }

    public SearchState() {}

    public String getSearchBar() {
        return this.searchBar;
    }

    public void setSearchBar(String search) {
        this.searchBar = search;
    }

}