package teams.service.createTeam;
public interface CreateTeamOutputBoundary {
    void prepareSuccessView(CreateTeamOutputData team);

    void prepareFailView(String error);
}
