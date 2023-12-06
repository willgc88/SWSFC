package teams.data_access;
import teams.entity.Team;
import teams.entity.TeamFactory;
import teams.service.createTeam.CreateTeamDataAccessInterface;
import users.entity.User;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileTeamDataAccessObject implements CreateTeamDataAccessInterface {

    private final File csvFile;
    private final Map<String, Integer> headers = new LinkedHashMap<>();
    private final Map<String, Team> teams = new HashMap<>();

    public FileTeamDataAccessObject(String csvPath, TeamFactory teamFactory) throws IOException {
        csvFile = new File(csvPath);
        headers.put("teamName", 0);

        if (csvFile.length() == 0) {
            save();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();
                assert header.equals("teamName");
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String teamName = String.valueOf(col[headers.get("teamName")]);
                    Team team = teamFactory.create(teamName,null,0,0);
                    teams.put(teamName, team);
                }
            }
        }
    }
    @Override
    public boolean existsByName(String identifier) {
        return teams.containsKey(identifier);
    }

    @Override
    public void save(Team team) {
        teams.put(team.getTeamName(), team);
        this.save();
    }
    private void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {


            for (Team team : teams.values()) {
                String line = "";
                String updatedLine = line + "," + team.getTeamName();
                writer.write(updatedLine);
                writer.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

