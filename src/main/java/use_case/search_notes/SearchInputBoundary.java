package use_case.search_notes;

import java.io.IOException;

public interface SearchInputBoundary {
    void execute(String search) throws IOException;
}