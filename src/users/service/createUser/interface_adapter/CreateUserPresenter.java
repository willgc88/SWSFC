package users.service.createUser.interface_adapter;

import users.service.createUser.CreateUserOutputBoundary;
import users.service.createUser.CreateUserOutputData;

public class CreateUserPresenter implements CreateUserOutputBoundary {
    private final CreateUserViewModel createUserViewModel;

    public CreateUserPresenter(CreateUserViewModel createUserViewModel) {
        this.createUserViewModel = createUserViewModel;
    }

    @Override
    public void prepareSuccessView(CreateUserOutputData response) {
        createUserViewModel.setState(new CreateUserState(response.getUsername));
        createUserViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CreateUserState createUserState = createUserViewModel.getState();
        createUserState.setUsernameError(error);
        createUserViewModel.firePropertyChanged();
    }
}
