package entity;

import enums.GameResult;

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
        clubOne.setNumberOfGamesPlayed(clubOne.getNumberOfGamesPlayed() + 1);
        clubTwo.setNumberOfGamesPlayed(clubTwo.getNumberOfGamesPlayed() + 1);
        if (result == GameResult.WIN) {
            clubOne.setScore(clubOne.getScore() + 3);
            clubOne.setNumberOfWins(clubOne.getNumberOfWins() + 1);
            clubTwo.setNumberOfWins(clubTwo.getNumberOFLosses() + 1);
        } else if (result == GameResult.DRAW) {
            clubOne.setScore(clubOne.getScore() + 1);
            clubTwo.setScore(clubTwo.getScore() + 1);
            ((SoccerClub) clubOne).setNumberOfDraws(((SoccerClub) clubOne).getNumberOfDraws() + 1);
            ((SoccerClub) clubTwo).setNumberOfDraws(((SoccerClub) clubTwo).getNumberOfDraws() + 1);
        } else {
            clubTwo.setScore(clubTwo.getScore() + 3);
            clubTwo.setNumberOfWins(clubTwo.getNumberOfWins() + 1);
            clubOne.setNumberOfWins(clubOne.getNumberOFLosses() + 1);
        }
    }

    public void scoreCalculation() {
        clubOne.setNumberOfGamesPlayed(clubOne.getNumberOfGamesPlayed() + 1);
        clubTwo.setNumberOfGamesPlayed(clubTwo.getNumberOfGamesPlayed() + 1);
        if (result == GameResult.WIN) {
            if (((VolleyballClub) clubTwo).getNumberOfLosingSets() == 2) {
                clubTwo.setScore(clubTwo.getScore() + 1);
                clubOne.setScore(clubOne.getScore() + 2);
            } else {
                clubOne.setScore(clubOne.getScore() + 3);
            }
        } else if (result == GameResult.LOSS) {
            if (((VolleyballClub) clubOne).getNumberOfLosingSets() == 2) {
                clubOne.setScore(clubOne.getScore() + 1);
                clubTwo.setScore(clubTwo.getScore() + 2);
            } else {
                clubTwo.setScore(clubTwo.getScore() + 3);
            }
        }
    }

}
