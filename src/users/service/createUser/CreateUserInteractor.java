package users.service.createUser;

import users.entity.HumanUser;
import users.entity.HumanUserFactory;

public class CreateUserInteractor implements CreateUserInputBoundary{

    final CreateUserDataAccessInterface createUserDataAccessObject;
    final CreateUserOutputBoundary userPresenter;
    final HumanUserFactory userFactory;

    public CreateUserInteractor(CreateUserDataAccessInterface createUserDataAccessInterface,
                                CreateUserOutputBoundary createUserOutputBoundary,
                                HumanUserFactory userFactory) {
        this.createUserDataAccessObject = createUserDataAccessInterface;
        this.userPresenter = createUserOutputBoundary;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(CreateUserInputData createUserInputData) {
        if (createUserDataAccessObject.existsByName(createUserInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else {
            HumanUser user = userFactory.create(createUserInputData.getUsername());
            createUserDataAccessObject.save(user);

            CreateUserOutputData createUserOutputData = new CreateUserOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(createUserOutputData);
        }
    }
}
