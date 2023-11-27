package teams.service.createTeam.interface_adapter;

import teams.entity.Team;

public class CreateTeamState {
    private String teamName = "";
    private String teamNameError = null;

    public CreateTeamState(CreateTeamState copy) {
        teamName = copy.teamName;
        teamNameError = copy.teamNameError;
    }

    public CreateTeamState() {
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamNameError() {
        return teamNameError;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setTeamNameError(String teamNameError) {
        this.teamNameError = teamNameError;
    }
}


