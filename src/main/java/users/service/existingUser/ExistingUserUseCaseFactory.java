package users.service.existingUser;

import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import users.service.existingUser.interface_adapter.ExistingUserController;
import users.service.existingUser.interface_adapter.ExistingUserPresenter;
import users.service.existingUser.interface_adapter.ExistingUserViewModel;
import view.ViewManagerModel;
import view.users.ExistingUserView;

import javax.swing.*;
import java.io.IOException;

public class ExistingUserUseCaseFactory {
    private ExistingUserUseCaseFactory() {}
    public static ExistingUserView create(
            ViewManagerModel viewManagerModel, CreateTeamViewModel createTeamViewModel, ExistingUserViewModel existingUserViewModel, ExistingUserDataAccessInterface existingUserDataAccessObject) {

        try {
            ExistingUserController existingUserController = existingUserUseCase(viewManagerModel, existingUserViewModel, createTeamViewModel, existingUserDataAccessObject);
            return new ExistingUserView(existingUserViewModel, existingUserController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not find user");
        }

        return null;
    }

    private static ExistingUserController existingUserUseCase(ViewManagerModel viewManagerModel, ExistingUserViewModel existingUserViewModel, CreateTeamViewModel createTeamViewModel, ExistingUserDataAccessInterface existingUserDataAccessObject) throws IOException {

//        // Notice how we pass this method's parameters to the Presenter.
//        ExistingUserOutputBoundary existingUserOutputBoundary = new ExistingUserPresenter(viewManagerModel, createTeamViewModel, existingUserViewModel);
//
//        ExistingUserInputBoundary existingUserInteractor = new ExistingUserInteractor(
//                existingUserDataAccessObject, existingUserOutputBoundary);
//
//        return new ExistingUserController(existingUserInteractor);
        return null;
    }
}
