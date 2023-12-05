package teams.service.createTeam.interface_adapter;

import draft.DraftState;
import teams.service.createTeam.CreateTeamOutputBoundary;
import teams.service.createTeam.CreateTeamOutputData;
import users.service.createUser.interface_adapter.CreateUserState;
import view.DraftViewModel;
import view.ViewManagerModel;

public class CreateTeamPresenter implements CreateTeamOutputBoundary {
    private final CreateTeamViewModel createTeamViewModel;
    private final DraftViewModel draftViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateTeamPresenter(CreateTeamViewModel createTeamViewModel, DraftViewModel draftViewModel, ViewManagerModel viewManagerModel) {
        this.createTeamViewModel = createTeamViewModel;
        this.draftViewModel = draftViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(CreateTeamOutputData team) {
        DraftState draftState = this.draftViewModel.getState();
        draftState.setTeamName(team.getTeamName());
        this.draftViewModel.setState(draftState);
        this.draftViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(this.draftViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CreateTeamState createTeamState = createTeamViewModel.getState();
        createTeamState.setTeamNameError(error);
        createTeamViewModel.firePropertyChanged();
    }
}
