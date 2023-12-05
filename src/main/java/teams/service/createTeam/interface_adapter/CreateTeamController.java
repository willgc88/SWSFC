package teams.service.createTeam.interface_adapter;

import teams.service.createTeam.CreateTeamInputBoundary;
import teams.service.createTeam.CreateTeamInputData;

public class CreateTeamController {
    final CreateTeamInputBoundary createTeamUseCaseInteractor;
    public CreateTeamController(CreateTeamInputBoundary createTeamUseCaseInteractor) {
        this.createTeamUseCaseInteractor = createTeamUseCaseInteractor;
    }

    public void execute(String teamName) {
        CreateTeamInputData createTeamInputData = new CreateTeamInputData(teamName);
        createTeamUseCaseInteractor.execute(createTeamInputData);
    }
}
