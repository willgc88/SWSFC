package users.entity;

import teams.entity.Team;

public class HumanUser implements User{

    private final String username;
    public Team team = null;

    /**
     * Requires: password is valid.
     * @param username
     */
    public HumanUser(String username) {
        this.username = username;
    }

    @Override
    public String getName() {return username;
    }
    @Override
    public Team getTeam() {return team;}

}
