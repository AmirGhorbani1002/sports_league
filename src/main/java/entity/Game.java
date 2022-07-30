package entity;

import enums.GameResult;
import math.MyMath;

public class Game {

    private final Club clubOne;
    private final Club clubTwo;
    private final GameResult result;

    public Game(Club clubOne, Club clubTwo, GameResult result) {
        this.clubOne = clubOne;
        this.clubTwo = clubTwo;
        this.result = result;
    }

    public void soccerScoreCalculation() {
        MyMath.calculateNumberOfMatches(clubOne, clubTwo);
        MyMath.calculateSoccerScore(clubOne, clubTwo, result);
    }

    public void volleyballScoreCalculation() {
        MyMath.calculateNumberOfMatches(clubOne, clubTwo);
        MyMath.calculateVolleyballScore(clubOne, clubTwo, result);
    }

}
