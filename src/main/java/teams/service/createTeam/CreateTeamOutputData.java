package teams.service.createTeam;

public class CreateTeamOutputData {
    private final String teamName;

    private boolean useCaseFailed;

    public CreateTeamOutputData(String teamName, boolean useCaseFailed) {
        this.teamName = teamName;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTeamName() {
        return teamName;
    }
}
