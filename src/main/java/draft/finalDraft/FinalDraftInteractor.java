package draft.finalDraft;

import draft.DraftInputBoundary;
import draft.DraftInputData;
import draft.DraftOutputBoundary;
import draft.DraftOutputData;

public class FinalDraftInteractor implements FinalDraftInputBoundary {
    FinalDraftOutputBoundary finalDraftPresenter;
    public FinalDraftInteractor(FinalDraftOutputBoundary finalDraftPresenter) {
        this.finalDraftPresenter = finalDraftPresenter;
    }
    @Override
    public void execute(FinalDraftInputData finalDraftInputData) {
        FinalDraftOutputData data = new FinalDraftOutputData(finalDraftInputData.getPosition(), finalDraftInputData.selection);
        finalDraftPresenter.prepareSuccessView(data);
    }


}
