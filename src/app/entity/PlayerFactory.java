package app.entity;

public class PlayerFactory {
    public Player create(String firstname, String lastname, String nation, String club, int age, int playerID) {
        return new Player(firstname, lastname, nation, club, age, playerID);
    }
}
