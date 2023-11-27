package users.service.createUser;

import teams.service.createTeam.CreateTeamOutputData;

public interface CreateUserOutputBoundary {
    void prepareSuccessView(CreateUserOutputData user);

    void prepareFailView(String error);
}
