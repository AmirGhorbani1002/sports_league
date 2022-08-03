package math;

import entity.Club;
import entity.SoccerClub;
import entity.VolleyballClub;
import enums.GameResult;

public class MyMath {

    public void calculateNumberOfMatches(Club clubOne, Club clubTwo) {
        clubOne.setNumberOfGamesPlayed(clubOne.getNumberOfGamesPlayed() + 1);
        clubTwo.setNumberOfGamesPlayed(clubTwo.getNumberOfGamesPlayed() + 1);
    }

    // for calculate soccer scores
    public void calculateSoccerScore(Club clubOne, Club clubTwo, GameResult result) {
        if (result == GameResult.WIN) {
            addScore(clubOne, 3);
            calculateNumberOfWinOrLose(clubOne, clubTwo);
        } else if (result == GameResult.DRAW) {
            addScore(clubOne, 1);
            addScore(clubTwo, 1);
            calculateNumberOfDraw((SoccerClub) clubOne, (SoccerClub) clubTwo);
        } else {
            addScore(clubTwo, 3);
            calculateNumberOfWinOrLose(clubTwo, clubOne);
        }
    }

    // for calculate volleyball scores
    public void calculateVolleyballScore(Club clubOne, Club clubTwo, GameResult result) {
        if (result == GameResult.WIN) {
            calculateNumberOfWinOrLose(clubOne, clubTwo);
            if (((VolleyballClub) clubTwo).getNumberOfWinningSets() == 2) {
                addScore(clubTwo, 1);
                addScore(clubOne, 2);
            } else {
                addScore(clubOne, 3);
            }
        } else if (result == GameResult.LOSS) {
            calculateNumberOfWinOrLose(clubTwo, clubOne);
            if (((VolleyballClub) clubOne).getNumberOfWinningSets() == 2) {
                addScore(clubOne, 1);
                addScore(clubTwo, 2);
            } else {
                addScore(clubTwo, 3);
            }
        }
    }

    private void addScore(Club club, int score) {
        club.setScore(club.getScore() + score);
    }

    private void calculateNumberOfWinOrLose(Club clubOne, Club clubTwo) {
        clubOne.setNumberOfWins(clubOne.getNumberOfWins() + 1);
        clubTwo.setNumberOFLosses(clubTwo.getNumberOFLosses() + 1);
    }

    private void calculateNumberOfDraw(SoccerClub clubOne, SoccerClub clubTwo) {
        clubOne.setNumberOfDraws(clubOne.getNumberOfDraws() + 1);
        clubTwo.setNumberOfDraws(clubTwo.getNumberOfDraws() + 1);
    }

}
