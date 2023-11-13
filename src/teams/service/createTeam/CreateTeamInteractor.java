package teams.service.createTeam;

import teams.entity.Team;
import teams.entity.TeamFactory;
import users.entity.User;
import users.service.createUser.CreateUserOutputData;


public class CreateTeamInteractor implements CreateTeamInputBoundary {
    final CreateTeamDataAccessInterface createTeamDataAccessObject;
    final CreateTeamOutputBoundary teamPresenter;
    final TeamFactory teamFactory;

    public CreateTeamInteractor(CreateTeamDataAccessInterface createTeamDataAccessObject, CreateTeamOutputBoundary teamPresenter, TeamFactory teamFactory) {
        this.createTeamDataAccessObject = createTeamDataAccessObject;
        this.teamPresenter = teamPresenter;
        this.teamFactory = teamFactory;
    }

    @Override
    public void execute(CreateTeamInputData createTeamInputData) {
        if (createTeamDataAccessObject.existsByName(createTeamInputData.getTeamName())) {
            teamPresenter.prepareFailView("Team with the such name already exists");
        } else {
            Team team = teamFactory.create(createTeamInputData.getTeamName(), null,0, 0);

            createTeamDataAccessObject.save(team);

            CreateTeamOutputData createTeamOutputData = new CreateTeamOutputData(team.getTeamName(), false);
            teamPresenter.prepareSuccessView(createTeamOutputData);
        }
    }
}
