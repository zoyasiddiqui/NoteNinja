package entity.Tag;

public class CommonTag implements Tag {

    private String attribute;

    public CommonTag(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getAttribute() {
        return this.attribute;
    }

    @Override
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}