package interface_adapter.edit_note;

import interface_adapter.ViewManagerModel;
import interface_adapter.search_notes.SearchViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.rename_note.RenameNoteOutputData;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EditNotePresenterTest {



    @Test
    void testPrepareTitleChange() {
        // Arrange
        SearchViewModel searchNoteViewModel = Mockito.mock(SearchViewModel.class);
        EditNoteViewModel editNoteViewModel = Mockito.mock(EditNoteViewModel.class);
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);

        EditNotePresenter editNotePresenter = new EditNotePresenter(searchNoteViewModel, editNoteViewModel, viewManagerModel);

        RenameNoteOutputData mockTitle = Mockito.mock(RenameNoteOutputData.class);
        when(mockTitle.getTitle()).thenReturn("New Note Title");

    }

    @Test
    void testPrepareBackMenu() {
        // Arrange
        SearchViewModel searchNoteViewModel = Mockito.mock(SearchViewModel.class);
        EditNoteViewModel editNoteViewModel = Mockito.mock(EditNoteViewModel.class);
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);

        EditNotePresenter editNotePresenter = new EditNotePresenter(searchNoteViewModel, editNoteViewModel, viewManagerModel);

        // Act
        editNotePresenter.prepareBackMenu();

        // Assert
        verify(viewManagerModel, Mockito.times(1)).setActiveView(searchNoteViewModel.getViewName());
        verify(viewManagerModel, Mockito.times(1)).firePropertyChanged();
    }
}
