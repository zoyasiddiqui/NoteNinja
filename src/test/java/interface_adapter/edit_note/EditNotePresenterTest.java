package interface_adapter.edit_note;

import interface_adapter.ViewManagerModel;
import interface_adapter.create_note.CreateNoteViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.edit_note.EditNoteOutputData;
import use_case.rename_note.RenameNoteOutputData;

import static org.mockito.Mockito.*;

class EditNotePresenterTest {

    @Mock
    private CreateNoteViewModel createNoteViewModel;

    @Mock
    private EditNoteViewModel editNoteViewModel;

    @Mock
    private ViewManagerModel viewManagerModel;

    @InjectMocks
    private EditNotePresenter editNotePresenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void prepareNote_shouldSetNoteStateAndChangeView() {
//
//    }
//
//    @Test
//    void prepareTitleChange_shouldSetTitleAndFirePropertyChanged() {
//
//    }
//
//    @Test
//    void prepareBackMenu_shouldSetActiveViewAndFirePropertyChanged() {
//
//    }
}
