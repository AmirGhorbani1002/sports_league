package entity;

import enums.GameResult;

public class VolleyballClub extends Club {

    private int numberOfWinningSets;
    private int numberOfLosingSets;

    public VolleyballClub(String name, int numberOfPlayers, String code) {
        super(name, numberOfPlayers, code);
    }

    @Override
    public void scoreCalculation(GameResult result) {
        setNumberOfGamesPlayed(getNumberOfGamesPlayed() + 1);
        if (result == GameResult.WIN) {
            if (getNumberOfLosingSets() == 2)
                setScore(getScore() + 2);
            else
                setScore(getScore() + 3);
            setNumberOfWins(getNumberOfWins() + 1);
        } else if (result == GameResult.LOSS) {
            if (getNumberOfWinningSets() == 2)
                setScore(getScore() + 1);
            setNumberOFLosses(getNumberOFLosses() + 1);
        }
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
