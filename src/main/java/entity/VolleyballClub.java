package entity;

import enums.GameResult;

public class VolleyballClub extends Club {

    private int numberOfWinningSets;
    private int numberOfLosingSets;

    public VolleyballClub(String name, int numberOfPlayers, String code) {
        super(name, numberOfPlayers, code);
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
}
