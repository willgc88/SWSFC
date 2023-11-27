package teams.service.createTeam;

public class CreateTeamInputData {
    final private String teamName;

    public CreateTeamInputData(String teamName) {
        this.teamName = teamName;
    }

    String getTeamName() {
        return teamName;
    }
}
