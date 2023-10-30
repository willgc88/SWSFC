package users.service.createUser;

public class CreateUserOutputData {
    private final String username;
    private boolean useCaseFailed;

    public CreateUserOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }
}
