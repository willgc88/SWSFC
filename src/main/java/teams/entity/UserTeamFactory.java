package teams.entity;
import java.util.List;
public class UserTeamFactory  implements TeamFactory{
    public Team create(String teamName, List<Player> roster, int rating, int chemistry) {
        return new Team(teamName, roster, rating, chemistry);
    }
}
