package draft;

public class DraftController {
    final DraftInputBoundary draftInteractor;
    public DraftController(DraftInputBoundary draftInteractor) {
        this.draftInteractor = draftInteractor;
    }

    public void execute(int position, int selection) {
        DraftInputData draftInputData = new DraftInputData(position, selection);
        draftInteractor.execute(draftInputData);
    }
}
