package view.startup;

import users.service.createUser.interface_adapter.CreateUserViewModel;
import users.service.existingUser.interface_adapter.ExistingUserViewModel;
import view.ViewManagerModel;

public class StartupUseCaseFactory {
    public static StartupView create(ViewManagerModel viewManagerModel,
                                     StartupViewModel startupViewModel,
                                     CreateUserViewModel createUserViewModel,
                                     ExistingUserViewModel existingUserViewModel) {
        StartupController startupController = new StartupController(new StartupInteractor(new StartupPresenter(
                startupViewModel, createUserViewModel, existingUserViewModel, viewManagerModel)));
        return new StartupView(startupViewModel, startupController);
    }
}
