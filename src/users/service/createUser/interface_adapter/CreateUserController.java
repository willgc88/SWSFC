package users.service.createUser.interface_adapter;

import users.service.createUser.CreateUserInputBoundary;
import users.service.createUser.CreateUserInputData;

public class CreateUserController {
    final CreateUserInputBoundary userCreateUserUseCaseInteractor;
    public CreateUserController(CreateUserInputBoundary userCreateUserUseCaseInteractor) {
        this.userCreateUserUseCaseInteractor = userCreateUserUseCaseInteractor;
    }

    public void execute(String username) {
        CreateUserInputData createUserInputData = new CreateUserInputData(
                username);

        userCreateUserUseCaseInteractor.execute(createUserInputData);
    }
}

