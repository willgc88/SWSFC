package entity;

public class HumanUser implements User{

    private final String username;
    private final String password;

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
    public String getName() {
        return username;
    }
}
