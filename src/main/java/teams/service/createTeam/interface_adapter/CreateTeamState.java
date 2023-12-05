package teams.service.createTeam.interface_adapter;

import teams.entity.Team;

public class CreateTeamState {
    private String teamName = null;
    private String username;
    private String teamNameError = null;

    public CreateTeamState(CreateTeamState copy) {
        teamName = copy.teamName;
        username = copy.username;
        teamNameError = copy.teamNameError;
    }

    public CreateTeamState() {
    }

    public String getTeamName() {
        return teamName;
    }

    public String getUsername() {
        return username;
    }

    public String getTeamNameError() {
        return teamNameError;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTeamNameError(String teamNameError) {
        this.teamNameError = teamNameError;
    }
}


