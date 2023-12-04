package users.service.existingUser;

public class ExistingUserOutputData {
    private final String teamName;
    private boolean useCaseFailed;

    public ExistingUserOutputData(String teamName, boolean useCaseFailed) {
        this.teamName = teamName;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTeamName() {
        return teamName;
    }

}
