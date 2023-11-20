package users.service.existingUser;

public interface ExistingUserOutputBoundary {
    void prepareSuccessView(ExistingUserOutputData user);

    void prepareFailView(String error);
}
