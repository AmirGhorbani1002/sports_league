package service;

import entity.Club;
import entity.SoccerClub;
import entity.VolleyballClub;
import object.ApplicationObjects;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {

    public void saveClub(Club club) throws SQLException {
        if (club instanceof SoccerClub) {
            ApplicationObjects.getSoccerRepository().save((SoccerClub) club);
            ApplicationObjects.getPersianSoccerClubPremierClubs().add(club);
        } else if (club instanceof VolleyballClub) {
            ApplicationObjects.getVolleyballRepository().save((VolleyballClub) club);
            ApplicationObjects.getPersianVolleyballClubPremierClubs().add(club);
        }
    }

    public void loadClubs(Club club) throws SQLException {
        if (club instanceof SoccerClub) {
            ResultSet resultSet = ApplicationObjects.getSoccerRepository().load();
            while (resultSet.next()) {
                SoccerClub soccerClub = new SoccerClub(resultSet.getString("name"), resultSet.getString("code"));
                ApplicationObjects.getPersianSoccerClubPremierClubs().add(soccerClub);
            }
            ApplicationObjects.getPersianSoccerClubPremier().setClubs(ApplicationObjects.getPersianSoccerClubPremierClubs());
        } else if (club instanceof VolleyballClub) {
            ResultSet resultSet = ApplicationObjects.getVolleyballRepository().load();
            while (resultSet.next()) {
                VolleyballClub volleyballClub = new VolleyballClub(resultSet.getString("name"), resultSet.getString("code"));
                ApplicationObjects.getPersianSoccerClubPremierClubs().add(volleyballClub);
            }
            ApplicationObjects.getPersianVolleyballClubPremier().setClubs(ApplicationObjects.getPersianVolleyballClubPremierClubs());
        }
    }

}
