package users.service.createUser;

import teams.service.createTeam.CreateTeamOutputData;

public interface CreateUserOutputBoundary {
    void prepareSuccessView(CreateUserOutputData user);

    void prepareSuccessView(CreateTeamOutputData response);

    void prepareFailView(String error);
}
