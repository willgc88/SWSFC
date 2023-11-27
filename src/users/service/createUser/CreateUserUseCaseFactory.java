package users.service.createUser;

import teams.service.createTeam.interface_adapter.CreateTeamViewModel;
import users.entity.HumanUserFactory;
import users.entity.UserFactory;
import users.service.createUser.CreateUserDataAccessInterface;
import users.service.createUser.CreateUserInputBoundary;
import users.service.createUser.CreateUserInteractor;
import users.service.createUser.CreateUserOutputBoundary;
import users.service.createUser.interface_adapter.CreateUserController;
import users.service.createUser.interface_adapter.CreateUserPresenter;
import users.service.createUser.interface_adapter.CreateUserViewModel;
import view.ViewManagerModel;
import view.users.CreateUserView;

import javax.swing.*;
import java.io.IOException;

public class CreateUserUseCaseFactory {
    private CreateUserUseCaseFactory() {}
    public static CreateUserView create(
            ViewManagerModel viewManagerModel, CreateTeamViewModel createTeamViewModel, CreateUserViewModel createUserViewModel, CreateUserDataAccessInterface createUserDataAccessObject) {

        try {
            CreateUserController createUserController = createUserUseCase(viewManagerModel, createUserViewModel, createTeamViewModel, createUserDataAccessObject);
            return new CreateUserView(createUserController, createUserViewModel);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Could not open user data file.");
        }

        return null;
    }

    private static CreateUserController createUserUseCase(ViewManagerModel viewManagerModel, CreateUserViewModel createUserViewModel, CreateTeamViewModel createTeamViewModel, CreateUserDataAccessInterface createUserDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        CreateUserOutputBoundary createUserOutputBoundary = new CreateUserPresenter(createUserViewModel, createTeamViewModel, viewManagerModel);
        UserFactory userFactory = new HumanUserFactory();

        CreateUserInputBoundary createUserInteractor = new CreateUserInteractor(
                createUserDataAccessObject, createUserOutputBoundary, userFactory);

        return new CreateUserController(createUserInteractor);
    }

}
