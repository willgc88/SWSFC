package app.entity;

public class Player {

    final String firstname;
    final String lastname;
    final String nation;
    final String club;
    final int age;
    Team team = null;
    final int playerID;
    PlayerStats playerStats;

    Player(String firstname, String lastname, String nation, String club, int age, int playerID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nation = nation;
        this.club = club;
        this.age = age;
        this.playerID = playerID;
    }
    public String getFirstname() {return firstname;}
    public String getLastname() {return lastname;}
    public String getNation() {return nation;}
    public int getAge() {return age;}
    public Team getTeam() {return team;}
    public int getPlayerID() {return playerID;}
    public PlayerStats getPlayerStats() {return playerStats;}
}