package service;

import entity.Club;
import entity.League;
import entity.SoccerClub;
import entity.VolleyballClub;
import object.ApplicationObjects;

public class UserService {

    public void addClub(League league, Club club) {
        ApplicationObjects.getScanner().nextLine();
        String name = ApplicationObjects.getScanner().nextLine();
        String code = ApplicationObjects.getScanner().nextLine();
        Club club2 = getClub(club, name, code);
        league.getClubs().add(club2);
    }

    private Club getClub(Club club, String name, String code) {
        if (club instanceof SoccerClub)
            return new SoccerClub(name, code);
        else
            return new VolleyballClub(name, code);
    }
}
