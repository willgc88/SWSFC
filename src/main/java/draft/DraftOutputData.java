package draft;

public class DraftOutputData {
    private int position;
    private String selection;
    public DraftOutputData(int position, String selection) {
        this.position = position;
        this.selection = selection;
    }

    int getPosition() {
        return position;
    }
    String getSelection() {
        return selection;
    }
}
