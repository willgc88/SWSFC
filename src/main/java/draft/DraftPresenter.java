package draft;

import view.DraftViewModel;
import view.ViewManagerModel;

public class DraftPresenter implements DraftOutputBoundary {
    private final DraftViewModel draftViewModel;
    private final ViewManagerModel viewManagerModel;

    public DraftPresenter(DraftViewModel draftViewModel, ViewManagerModel viewManagerModel){
        this.draftViewModel = draftViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DraftOutputData data) {
        //switch to team info view
    }

    @Override
    public void prepareFailView(String error) {

    }
}
