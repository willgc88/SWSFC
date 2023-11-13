package users.service.existingUser.interface_adapter;

import users.service.existingUser.ExistingUserInputBoundary;
import users.service.existingUser.ExistingUserOutputBoundary;
import users.service.existingUser.ExistingUserOutputData;
import users.service.loggedIn.interface_adapter.LoggedInState;
import users.service.loggedIn.interface_adapter.LoggedInViewModel;
import view.ViewManagerModel;

public class ExistingUserPresenter implements ExistingUserOutputBoundary {

    private final ExistingUserViewModel existingUserViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public ExistingUserPresenter(ViewManagerModel viewManagerModel,
                                 LoggedInViewModel loggedInViewModel,
                                 ExistingUserViewModel existingUserViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.existingUserViewModel = existingUserViewModel;
    }

    @Override
    public void prepareSuccessView(ExistingUserOutputData response) {
        // On success, switch to the logged in view.

        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ExistingUserState existingUserState = existingUserViewModel.getState();
        existingUserState.setUsernameError(error);
        existingUserViewModel.firePropertyChanged();
    }
}
