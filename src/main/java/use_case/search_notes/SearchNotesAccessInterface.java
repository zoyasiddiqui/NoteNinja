package use_case.search_notes;

import entity.Note.Note;

import java.util.List;

public interface SearchNotesAccessInterface {

    Note findByTitle(String noteTitle);

}