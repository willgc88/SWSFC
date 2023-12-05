package draft;

public class DraftInputData {
    int position;
    int selection;

    public DraftInputData(int position, int selection) {
        this.position = position;
        this.selection = selection;
    }

    public int getPosition() {
        return position;
    }

    public int getSelection() {
        return selection;
    }
}
