package interface_adapter.create_note;

import java.util.List;

public class CreateNoteState {
    private String title;
    private List<String> text;

    public CreateNoteState() {}
    public CreateNoteState(CreateNoteState copy) {
        this.title = copy.title;
        this.text = copy.text;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getText() {
        return this.text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

}