package teams.service.createTeam.interface_adapter;

import teams.service.createTeam.CreateTeamOutputBoundary;
import teams.service.createTeam.CreateTeamOutputData;
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

    }

    @Override
    public void prepareFailView(String error) {

    }
}
