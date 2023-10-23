package entity;

public class HumanUser implements User{

    private final String username;
    private final String password;
    public Team team = null;

    /**
     * Requires: password is valid.
     * @param username
     * @param password
     */
    public HumanUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getName() {return username;
    }
    @Override
    public Team getTeam() {return team;}

}
