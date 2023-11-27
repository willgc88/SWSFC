package users.service.existingUser;

public class ExistingUserOutputData {
    private final String username;
    private boolean useCaseFailed;

    public ExistingUserOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

    public String getUsername() {
        return username;
    }

}
