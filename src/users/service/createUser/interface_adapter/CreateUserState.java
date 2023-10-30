package users.service.createUser.interface_adapter;

public class CreateUserState {
    private String username = "";
    private String usernameError = null;

    public CreateUserState(CreateUserState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
    }
    public CreateUserState() {
    }
    public String getUsername() {
        return username;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }
    @Override
    public String toString() {
        return "CreateUserState{" +
                "username='" + username + '\'' +
                '}';
    }
}


