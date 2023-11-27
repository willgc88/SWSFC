package teams.service.createTeam;

import users.service.createUser.CreateUserOutputData;

public interface CreateTeamOutputBoundary {
    void prepareSuccessView(CreateTeamOutputData team);

    void prepareFailView(String error);
}
