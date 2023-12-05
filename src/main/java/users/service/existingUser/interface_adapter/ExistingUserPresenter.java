package users.service.existingUser.interface_adapter;

import teams.service.createTeam.interface_adapter.CreateTeamState;
import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import users.service.existingUser.ExistingUserOutputBoundary;
import users.service.existingUser.ExistingUserOutputData;

import view.ViewManagerModel;

public class ExistingUserPresenter implements ExistingUserOutputBoundary {

    private final ExistingUserViewModel existingUserViewModel;
    private final CreateTeamViewModel createTeamViewModel;
    private ViewManagerModel viewManagerModel;

    public ExistingUserPresenter(ViewManagerModel viewManagerModel,
                                 CreateTeamViewModel createTeamViewModel,
                                 ExistingUserViewModel existingUserViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.createTeamViewModel = createTeamViewModel;
        this.existingUserViewModel = existingUserViewModel;
    }

    @Override
    public void prepareSuccessView(ExistingUserOutputData response) {

        CreateTeamState createTeamState = createTeamViewModel.getState();
        createTeamState.setUsername(response.getUsername());
        this.createTeamViewModel.setState(createTeamState);
        this.createTeamViewModel.firePropertyChanged();
        System.out.println(response.getUsername());
        this.viewManagerModel.setActiveView(createTeamViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ExistingUserState existingUserState = existingUserViewModel.getState();
        existingUserState.setUsernameError(error);
        existingUserViewModel.firePropertyChanged();
    }
}
