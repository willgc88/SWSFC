package users.service.createUser;

import users.entity.HumanUser;
import users.entity.HumanUserFactory;
import users.entity.User;
import users.entity.UserFactory;

public class CreateUserInteractor implements CreateUserInputBoundary{
    final CreateUserDataAccessInterface createUserDataAccessObject;
    final CreateUserOutputBoundary userPresenter;
    final UserFactory userFactory;


    public CreateUserInteractor(CreateUserDataAccessInterface createUserDataAccessObject, CreateUserOutputBoundary userPresenter, UserFactory userFactory) {
        this.createUserDataAccessObject = createUserDataAccessObject;
        this.userFactory = userFactory;
        this.userPresenter = userPresenter;

    }

    @Override
    public void execute(CreateUserInputData createUserInputData) {
        if (createUserDataAccessObject.existsByName(createUserInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");}
        else {
            User user = userFactory.create(createUserInputData.getUsername());

            createUserDataAccessObject.save(user);

            CreateUserOutputData createUserOutputData = new CreateUserOutputData(user.getName(), false);
            userPresenter.prepareSuccessView(createUserOutputData);
        }
    }
}
