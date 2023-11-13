package users.service.createUser;

public interface CreateUserOutputBoundary {
    void prepareSuccessView(CreateUserOutputData user);

    void prepareFailView(String error);
}
