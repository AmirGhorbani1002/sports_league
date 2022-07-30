package entity;

public class VolleyballClub extends Club {

    private int numberOfWinningSets;
    private int numberOfLosingSets;

    public VolleyballClub(String name, int numberOfPlayers, String code) {
        super(name, 6, code);
    }
    public int getNumberOfWinningSets() {
        return numberOfWinningSets;
    }

    public void setNumberOfWinningSets(int numberOfWinningSets) {
        this.numberOfWinningSets = numberOfWinningSets;
    }

    public int getNumberOfLosingSets() {
        return numberOfLosingSets;
    }

    public void setNumberOfLosingSets(int numberOfLosingSets) {
        this.numberOfLosingSets = numberOfLosingSets;
    }

    @Override
    public String toString(){
        return "| code: " + getCode() + " | name: " + getName() + " | number of games: "
                + getNumberOfGamesPlayed() + " | number of wins: " + getNumberOfWins() + " | number of losses: "
                + getNumberOFLosses() + " | score: " + getScore() + " |";
    }

}
