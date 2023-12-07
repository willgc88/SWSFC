package teams.entity;

import java.util.List;

public interface TeamFactory {
    Team create(String teamName, List<Player> roster, int raiting, int chemistry);
}
