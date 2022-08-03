package service;

import check.Check;
import entity.*;
import enums.GameResult;
import object.ApplicationObjects;
import util.ClubList;
import util.LeagueList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class UserService {

    public void saveClub(League league, String checkType, String name, String code) throws SQLException {
        if (loadClubByName(league, name) != null || loadClubByCode(league, code) != null) {
            Check.printMessage("There is a club with this name or code");
        } else {
            Club club2 = getClub(checkType, name, code);
            league.getClubs().add(club2);
            saveLeague(league, checkType);
        }
    }

    public Club loadClubByName(League league, String name) {
        for (Club club : league.getClubs().getClubs()) {
            if (club != null) {
                if (Objects.equals(club.getName(), name)) {
                    return club;
                }
            }
        }
        return null;
    }

    public Club loadClubByCode(League league, String code) {
        for (Club club : league.getClubs().getClubs()) {
            if (club != null) {
                if (Objects.equals(club.getCode(), code)) {
                    return club;
                }
            }
        }
        return null;
    }

    public String[] loadAllLeagues() throws SQLException {
        String[] information = ApplicationObjects.getLeagueRepository().load();
        String[] type = new String[1000];
        ApplicationObjects.getLeagueList().setIndex(0);
        int typeIndex = 0;
        for (int i = 0; i < information.length; i += 3) {
            type[typeIndex++] = information[i + 2];
            if (information[i] != null) {
                League league;
                if (Objects.equals(information[i + 2], "soccer"))
                    league = new League(information[i], ApplicationObjects.getClubToString().stringToSoccerClubs(information[i + 1]));
                else
                    league = new League(information[i], ApplicationObjects.getClubToString().stringToVolleyballClubs(information[i + 1]));
                ApplicationObjects.getLeagueList().add(league);
            } else break;
        }
        return type;
    }

    public void saveLeague(League league, String checkType) throws SQLException {
        String clubs;
        if (Objects.equals(checkType, "soccer"))
            clubs = ApplicationObjects.getClubToString().soccerClubsToString(league.getClubs());
        else
            clubs = ApplicationObjects.getClubToString().volleyballClubsToString(league.getClubs());
        ApplicationObjects.getLeagueRepository().updateClubs(league, clubs);
    }

    public void saveLeague(League league, Club checkType) throws SQLException {
        String clubs;
        if (checkType instanceof SoccerClub)
            clubs = ApplicationObjects.getClubToString().soccerClubsToString(league.getClubs());
        else
            clubs = ApplicationObjects.getClubToString().volleyballClubsToString(league.getClubs());
        ApplicationObjects.getLeagueRepository().updateClubs(league, clubs);
    }

    public void showTable(League league) {
        if (league.getClubs().getClubs()[0] == null) {
            Check.printMessage("This league does not have any clubs yet");
        } else {
            for (Club club : league.getClubs().getClubs()) {
                if (club != null)
                    System.out.println(club);
                else break;
            }
        }
    }

    public void deleteClub(League league, String name) {
        if (loadClubByName(league, name) == null) {
            Check.printMessage("There is no club with this profile");
        } else {
            for (Club club : league.getClubs().getClubs()) {
                if (Objects.equals(club.getName(), name)) {
                    league.getClubs().remove(name);
                    break;
                }
            }
        }
    }

    public void addGame(League league, Club clubOne, Club clubTwo, GameResult result) throws SQLException {
        Game game = new Game(clubOne, clubTwo, result);
        scoreCalculate(clubOne, game);
        saveLeague(league, clubOne);
    }

    public void addLeague(String name, String type) throws SQLException {
        ApplicationObjects.getLeagueRepository().save(name,type);
    }

    private void scoreCalculate(Club clubOne, Game game) {
        if (clubOne instanceof SoccerClub)
            game.soccerScoreCalculation();
        else
            game.volleyballScoreCalculation();
    }

    private Club getClub(String checkType, String name, String code) {
        if (Objects.equals(checkType, "soccer"))
            return new SoccerClub(name, code);
        else
            return new VolleyballClub(name, code);
    }
}
