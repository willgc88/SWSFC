package draft.finalDraft.interfaceAdapters;

import draft.DraftOutputData;
import draft.finalDraft.FinalDraftOutputBoundary;
import draft.finalDraft.FinalDraftOutputData;
import view.ViewManagerModel;

public class FinalDraftPresenter implements FinalDraftOutputBoundary {
    private final FinalDraftViewModel finaldraftViewModel;
    private final ViewManagerModel viewManagerModel;

    public FinalDraftPresenter(FinalDraftViewModel finalDraftViewModel, ViewManagerModel viewManagerModel){
        this.finaldraftViewModel = finalDraftViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(FinalDraftOutputData data) {
        //switch to team info view
    }

    @Override
    public void prepareFailView(String error) {

    }
}