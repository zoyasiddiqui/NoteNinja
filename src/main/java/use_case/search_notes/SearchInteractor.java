package use_case.search_notes;

import entity.Note.Note;
import interface_adapter.edit_note.EditNotePresenter;
import use_case.edit_note.EditNoteOutputBoundary;
import use_case.edit_note.EditNoteOutputData;
import java.util.List;

import java.io.IOException;

public class SearchInteractor implements SearchInputBoundary{

    final SearchNotesAccessInterface searchNotesAccessInterface;
    final EditNoteOutputBoundary editNotePresenter;

    public SearchInteractor(SearchNotesAccessInterface searchNotesAccessInterface,
                            EditNoteOutputBoundary editNotePresenter) {
        this.searchNotesAccessInterface = searchNotesAccessInterface;
        this.editNotePresenter = editNotePresenter;
    }

    @Override
    public void execute(String search) throws IOException {
        Note note = this.searchNotesAccessInterface.findByTitle(search);

        if(note != null) {
            EditNoteOutputData editNoteOutputData = new EditNoteOutputData(note.getID(),
                    note.getName(), note.getText());
            editNotePresenter.prepareNote(editNoteOutputData);
        }

    }
}