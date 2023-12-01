package teams.entity;

public class Player {

    final String name;
    final String club;
    final String position;
    final int playerID;

    public Player(String name, String club, String position, int playerID) {
        this.name = name;
        this.club = club;
        this.position = position;
        this.playerID = playerID;
    }
    public String getName() {return name;}
    public String getPosition() {return position;}
    public String getClub() {return club;}
    public int getPlayerID() {return playerID;}
}