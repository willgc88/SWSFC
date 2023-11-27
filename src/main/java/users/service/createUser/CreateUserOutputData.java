package users.service.createUser;

import teams.entity.Team;

public class CreateUserOutputData {
    private final String username;
    private final Team team;

    private boolean useCaseFailed;

    public CreateUserOutputData(String username, Team team, boolean useCaseFailed) {
        this.username = username;
        this.team = team;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }
    public Team getTeam() {return team;}
}
