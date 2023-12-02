package use_case.search_notes;

import java.io.IOException;
import entity.Note.Note;
import java.util.List;

public interface SearchInputBoundary {
    void execute(String search) throws IOException;
}