package users.service.existingUser.interface_adapter;

import users.service.existingUser.ExistingUserInputBoundary;
import users.service.existingUser.ExistingUserInputData;

public class ExistingUserController {
    final ExistingUserInputBoundary existingUserUseCaseInteractor;
    public ExistingUserController(ExistingUserInputBoundary existingUserUseCaseInteractor) {
        this.existingUserUseCaseInteractor = existingUserUseCaseInteractor;
    }


    public void execute(String username) {
        ExistingUserInputData existingUserInputData = new ExistingUserInputData(
                username);

        existingUserUseCaseInteractor.execute(existingUserInputData);
    }
}

