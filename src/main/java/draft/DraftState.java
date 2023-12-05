package draft;

public class DraftState {
    public String teamName;
    public DraftState(DraftState copy) {
        teamName = copy.teamName;
    }
    public DraftState() {};
    public String getTeamName() {
        return this.teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
