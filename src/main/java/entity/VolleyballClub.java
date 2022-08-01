package entity;

public class VolleyballClub extends Club {

    private int numberOfWinningSets;

    public VolleyballClub(String name, String code) {
        super(name, 6, code);
    }
    public int getNumberOfWinningSets() {
        return numberOfWinningSets;
    }

    public void setNumberOfWinningSets(int numberOfWinningSets) {
        this.numberOfWinningSets = numberOfWinningSets;
    }

    @Override
    public String toString(){
        return "| code: " + getCode() + " | name: " + getName() + " | number of games: "
                + getNumberOfGamesPlayed() + " | number of wins: " + getNumberOfWins() + " | number of losses: "
                + getNumberOFLosses() + " | score: " + getScore() + " |";
    }

}
