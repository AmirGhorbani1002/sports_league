package service;

import entity.Club;
import entity.League;
import entity.SoccerClub;
import entity.VolleyballClub;
import list.ClubList;

public class ClubsToString {

    public String soccerClubsToString(ClubList clubs) {
        String temp = "";
        for (Club club : clubs.getClubs()) {
            if (club != null) {
                temp += club.getCode() + "-";
                temp += club.getName() + "-";
                temp += club.getNumberOfGamesPlayed() + "-";
                temp += club.getNumberOfWins() + "-";
                temp += ((SoccerClub) club).getNumberOfDraws() + "-";
                temp += club.getNumberOFLosses() + "-";
                temp += club.getScore() + "-";
            }
        }
        return temp;
    }

    public void stringToSoccerClubs(League league, String clubs) {
        String[] temp = null;
        if (clubs != null) {
            temp = clubs.split("-");
            for (int i = 0; i < temp.length; i += 7) {
                SoccerClub soccerClub = new SoccerClub(temp[i], temp[i + 1]);
                soccerClub.setNumberOfGamesPlayed(Integer.parseInt(temp[i + 2]));
                soccerClub.setNumberOfWins(Integer.parseInt(temp[i + 3]));
                soccerClub.setNumberOfDraws(Integer.parseInt(temp[i + 4]));
                soccerClub.setNumberOFLosses(Integer.parseInt(temp[i + 5]));
                soccerClub.setScore(Integer.parseInt(temp[i + 6]));
                league.getClubs().add(soccerClub);
            }
        }
    }

    public String volleyballClubsToString(ClubList clubs) {
        String temp = "";
        for (Club club : clubs.getClubs()) {
            if (club != null) {
                temp += club.getCode() + "-";
                temp += club.getName() + "-";
                temp += club.getNumberOfGamesPlayed() + "-";
                temp += club.getNumberOfWins() + "-";
                temp += club.getNumberOFLosses() + "-";
                temp += club.getScore() + "-";
            }
        }
        return temp;
    }

    public void stringToVolleyballClubs(League league, String clubs) {
        String[] temp = null;
        if (clubs != null) {
            temp = clubs.split("-");
            for (int i = 0; i < temp.length; i += 6) {
                VolleyballClub volleyballClub = new VolleyballClub(temp[i], temp[i + 1]);
                volleyballClub.setNumberOfGamesPlayed(Integer.parseInt(temp[i + 2]));
                volleyballClub.setNumberOfWins(Integer.parseInt(temp[i + 3]));
                volleyballClub.setNumberOFLosses(Integer.parseInt(temp[i + 4]));
                volleyballClub.setScore(Integer.parseInt(temp[i + 5]));
                league.getClubs().add(volleyballClub);
            }
        }
    }

}
