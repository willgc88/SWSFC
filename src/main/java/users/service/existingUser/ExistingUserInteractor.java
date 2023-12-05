package users.service.existingUser;

import users.entity.User;

public class ExistingUserInteractor implements ExistingUserInputBoundary {
    final ExistingUserDataAccessInterface userDataAccessObject;
    final ExistingUserOutputBoundary loginPresenter;

    public ExistingUserInteractor(ExistingUserDataAccessInterface userDataAccessInterface,
                           ExistingUserOutputBoundary existingUserOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = existingUserOutputBoundary;
    }

    @Override
    public void execute(ExistingUserInputData existingUserInputData) {
        String username = existingUserInputData.getUsername();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
            } else {
                User user = userDataAccessObject.get(existingUserInputData.getUsername());

                ExistingUserOutputData existingUserOutputData = new ExistingUserOutputData(user.getName(), false);
                loginPresenter.prepareSuccessView(existingUserOutputData);
            }
        }
    }
