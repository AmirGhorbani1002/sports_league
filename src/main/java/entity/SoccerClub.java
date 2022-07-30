package entity;

import enums.GameResult;

public class SoccerClub extends Club{

    private int numberOfDraws;

    public SoccerClub(String name, String code) {
        super(name, 11, code);
        numberOfDraws = 0;
    }

    @Override
    public void scoreCalculation(GameResult result) {
        setNumberOfGamesPlayed(getNumberOfGamesPlayed() + 1);
        if(result == GameResult.WIN){
            setScore(getScore() + 3);
            setNumberOfWins(getNumberOfWins() + 1);
        }
        else if(result == GameResult.DRAW){
            numberOfDraws++;
        } else {
            setNumberOFLosses(getNumberOFLosses() + 1);
        }
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }
}
