package users.service.createUser.interface_adapter;

import teams.service.createTeam.CreateTeamOutputData;
import teams.service.createTeam.interface_adapter.CreateTeamState;
import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import users.service.createUser.CreateUserOutputBoundary;
import users.service.createUser.CreateUserOutputData;
import view.ViewManagerModel;

public class CreateUserPresenter implements CreateUserOutputBoundary {
    private final CreateUserViewModel createUserViewModel;
    private final CreateTeamViewModel createTeamViewModel;
    private ViewManagerModel viewManagerModel;

    public CreateUserPresenter(CreateUserViewModel createUserViewModel, CreateTeamViewModel createTeamViewModel, ViewManagerModel viewManagerModel) {
        this.createUserViewModel = createUserViewModel;
        this.createTeamViewModel = createTeamViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(CreateUserOutputData user) {
        CreateTeamState createTeamState = createTeamViewModel.getState();
        createTeamState.setTeamName(user.getTeam().getTeamName());
        this.createTeamViewModel.setState(createTeamState);
        this.createTeamViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(createTeamViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CreateUserState createUserState = createUserViewModel.getState();
        createUserState.setUsernameError(error);
        createUserViewModel.firePropertyChanged();
    }
}
