package use_case.search_notes;

public interface SearchNotesAccessInterface {

    void findByName(String name);
    void findByTag(String tagName);

}