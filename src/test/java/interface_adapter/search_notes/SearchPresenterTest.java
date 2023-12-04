package interface_adapter.search_notes;

import interface_adapter.ViewManagerModel;
import interface_adapter.edit_note.EditNoteViewModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class SearchPresenterTest {

    @Test
    void testPrepareFailView() {
        // Arrange
        SearchViewModel searchViewModel = Mockito.mock(SearchViewModel.class);
        EditNoteViewModel editNoteViewModel = Mockito.mock(EditNoteViewModel.class);
        ViewManagerModel viewManagerModel = Mockito.mock(ViewManagerModel.class);

        SearchPresenter searchPresenter = new SearchPresenter(searchViewModel, editNoteViewModel, viewManagerModel);

        // Act
        searchPresenter.prepareFailView("Test Error Message");

    }
}
