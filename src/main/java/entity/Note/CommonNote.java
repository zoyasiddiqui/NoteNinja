package entity.Note;

class CommonNote implements Note {
    private String name;
    private String text;
    private int ID;

    public CommonNote(String name, String text, int ID) {
        this.name = name;
        this.text = text;
        this.ID = ID;
    }

    @Override
    public void setName(String title) {
        this.name = title;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getText() {
        return this.text;
    }

    public int getID() {
        return ID;
    }
}