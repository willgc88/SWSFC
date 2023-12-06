package draft.finalDraft;

public class FinalDraftOutputData {
    private int position;
    private int selection;
    public FinalDraftOutputData(int position, int selection) {
        this.position = position;
        this.selection = selection;
    }

    int getPosition() {
        return position;
    }
    int getSelection() {
        return selection;
    }
}


