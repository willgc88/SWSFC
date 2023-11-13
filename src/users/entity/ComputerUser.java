package users.entity;

import teams.entity.Team;

public class ComputerUser implements User{
    private final String name = "Computer";
    public Team team;

    public ComputerUser (Team team) {
        this.team = team;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Team getTeam() {
        return null;
    }
}
