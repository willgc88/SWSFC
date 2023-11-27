package users.service.createUser;

public class CreateUserInputData {
    final private String username;

    public CreateUserInputData(String username) {
        this.username = username;
    }

    public String getUsername() { return username; }
}
