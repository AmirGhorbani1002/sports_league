package entity;


public class SoccerClub extends Club{

    private int numberOfDraws;

    public SoccerClub(String name, String code) {
        super(name, 11, code);
        numberOfDraws = 0;
    }
    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    @Override
    public String toString(){
        return "| code: " + getCode() + " | name: " + getName() + " | number of games: "
                + getNumberOfGamesPlayed() + " | number of wins: " + getNumberOfWins()
                + " | number of draws: " + getNumberOfDraws() + " | number of losses: "
                + getNumberOFLosses() + " | score: " + getScore() + " |";
    }

}
