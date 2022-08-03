package entity;

import check.Check;
import enums.GameResult;
import math.MyMath;

public class Game {

    private final Club clubOne;
    private final Club clubTwo;
    private final GameResult result;
    private final MyMath myMath = new MyMath();

    public Game(Club clubOne, Club clubTwo, GameResult result) {
        this.clubOne = clubOne;
        this.clubTwo = clubTwo;
        this.result = result;
    }

    public void soccerScoreCalculation() {
        myMath.calculateNumberOfMatches(clubOne, clubTwo);
        myMath.calculateSoccerScore(clubOne, clubTwo, result);
    }

    public void volleyballScoreCalculation() {
        myMath.calculateNumberOfMatches(clubOne, clubTwo);
        myMath.calculateVolleyballScore(clubOne, clubTwo, result);
    }

}
