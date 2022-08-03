package entity;


import math.MyMath;

public class SoccerClub extends Club{

    private int numberOfDraws;

    public SoccerClub(String code, String name) {
        super(code, 11, name);
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
