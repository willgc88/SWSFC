package draft;

import draft.finalDraft.interfaceAdapters.FinalDraftState;
import view.DraftViewModel;
import view.FinalDraftViewModel;
import view.ViewManagerModel;

public class DraftPresenter implements DraftOutputBoundary {
    private final DraftViewModel draftViewModel;
    private final ViewManagerModel viewManagerModel;
    private final FinalDraftViewModel finalDraftViewModel;

    public DraftPresenter(DraftViewModel draftViewModel, ViewManagerModel viewManagerModel, FinalDraftViewModel finalDraftViewModel){
        this.draftViewModel = draftViewModel;
        this.viewManagerModel = viewManagerModel;
        this.finalDraftViewModel = finalDraftViewModel;
    }

    @Override
    public void prepareSuccessView(DraftOutputData data) {
        FinalDraftState finalDraftState = finalDraftViewModel.getState();
        finalDraftState.setPlayers(data.players);
        finalDraftState.setTeamName(data.teamName);

        this.finalDraftViewModel.setState(finalDraftState);
        this.finalDraftViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(finalDraftViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}
