package draft;

public class DraftInteractor implements DraftInputBoundary {
    DraftOutputBoundary draftPresenter;
    public DraftInteractor(DraftOutputBoundary draftPresenter) {
        this.draftPresenter = draftPresenter;
    }
    @Override
    public void execute(DraftInputData draftInputData) {
        //update draft view
    }
}
