package view.startup;

import users.service.createUser.interface_adapter.CreateUserState;
import users.service.createUser.interface_adapter.CreateUserViewModel;
import users.service.existingUser.interface_adapter.ExistingUserState;
import users.service.existingUser.interface_adapter.ExistingUserViewModel;
import view.ViewManagerModel;

class StartupPresenter implements StartupOutputBoundary {
    private final StartupViewModel startupViewModel;
    private final CreateUserViewModel createUserViewModel;
    private final ExistingUserViewModel existingUserViewModel;
    private ViewManagerModel viewManagerModel;

    StartupPresenter(StartupViewModel startupViewModel,
                     CreateUserViewModel createUserViewModel,
                     ExistingUserViewModel existingUserViewModel,
                     ViewManagerModel viewManagerModel) {

        this.startupViewModel = startupViewModel;
        this.createUserViewModel = createUserViewModel;
        this.existingUserViewModel = existingUserViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareCreateUserView() {
        CreateUserState createUserState = createUserViewModel.getState();
        this.createUserViewModel.setState(createUserState);
        this.createUserViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(createUserViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
    public void prepareExistingUserView() {
        ExistingUserState existingUserState = existingUserViewModel.getState();
        this.existingUserViewModel.setState(existingUserState);
        this.existingUserViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(existingUserViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}