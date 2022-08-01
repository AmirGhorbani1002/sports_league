package service;

import entity.*;
import enums.GameResult;
import object.ApplicationObjects;

import java.util.Objects;

public class UserService {

    public void saveClub(League league, Club checkType, String name, String code) {
        Club club2 = getClub(checkType, name, code);
        league.getClubs().add(club2);
    }

    public Club loadClub(League league, String name) {
        for (Club club : league.getClubs().getClubs()) {
            if (Objects.equals(club.getName(), name)) {
                return club;
            }
        }
        return null;
    }

    public void deleteClub(League league, String name) {
        for (Club club : league.getClubs().getClubs()) {
            if (Objects.equals(club.getName(), name)) {
                league.getClubs().remove(name);
                break;
            }
        }
    }

    public void addGame(League league, Club clubOne, Club clubTwo, GameResult result) {
        Game game = new Game(clubOne, clubTwo, result);
        scoreCalculate(clubOne, game);
    }

    private void scoreCalculate(Club clubOne, Game game) {
        if (clubOne instanceof SoccerClub)
            game.soccerScoreCalculation();
        else
            game.volleyballScoreCalculation();
    }

    private Club getClub(Club club, String name, String code) {
        if (club instanceof SoccerClub)
            return new SoccerClub(name, code);
        else
            return new VolleyballClub(name, code);
    }
}
