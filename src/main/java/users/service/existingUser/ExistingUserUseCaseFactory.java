package users.service.existingUser;

import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import users.entity.HumanUserFactory;
import users.entity.UserFactory;
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
            ViewManagerModel viewManagerModel,ExistingUserViewModel existingUserViewModel, CreateTeamViewModel createTeamViewModel, ExistingUserDataAccessInterface userDataAccessObject) {

        try {
            ExistingUserController existingUserController = existingUserUseCase(viewManagerModel, existingUserViewModel, createTeamViewModel, userDataAccessObject);
            return new ExistingUserView(existingUserViewModel, existingUserController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not find user");
        }

        return null;
    }

    private static ExistingUserController existingUserUseCase(ViewManagerModel viewManagerModel, ExistingUserViewModel existingUserViewModel, CreateTeamViewModel createTeamViewModel, ExistingUserDataAccessInterface existingUserDataAccessObject) throws IOException {
        ExistingUserOutputBoundary existingUserOutputBoundary = new ExistingUserPresenter(viewManagerModel, createTeamViewModel, existingUserViewModel);

        UserFactory userFactory = new HumanUserFactory();

        ExistingUserInputBoundary existingUserInteractor = new ExistingUserInteractor(
                existingUserDataAccessObject, existingUserOutputBoundary);

        return new ExistingUserController(existingUserInteractor);

    }
}
