package use_case.search_notes;

import entity.Note.Note;

public interface SearchNotesAccessInterface {

    Note findByTitle(String noteTitle);

}