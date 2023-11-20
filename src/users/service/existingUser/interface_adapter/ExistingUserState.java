package users.service.existingUser.interface_adapter;

public class ExistingUserState {
    private String username = "";
    private String usernameError = null;

    public ExistingUserState(ExistingUserState copy) {
        username = copy.username;
        usernameError = copy.usernameError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ExistingUserState() {}

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
}


