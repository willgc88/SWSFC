package teams.entity;

import java.util.List;

public class Team {
    String teamName;
    List<Player> roster;
    int rating;
    int chemistry;

    public Team(String teamName, List<Player> roster, int rating, int chemistry) {
        this.teamName = teamName;
        this.roster = roster;
        this.rating = rating;
        this.chemistry = chemistry;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getChemistry() {
        return chemistry;
    }

    public int getRating() {
        return rating;
    }

    public List<Player> getRoster() {
        return roster;
    }
}