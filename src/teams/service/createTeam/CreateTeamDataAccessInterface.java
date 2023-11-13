package teams.service.createTeam;

import teams.entity.Team;

public interface CreateTeamDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Team team);
}
