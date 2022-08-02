package view;

import check.Check;
import entity.SoccerClub;
import entity.VolleyballClub;
import object.ApplicationObjects;

import java.sql.SQLException;
import java.util.Objects;

public class OurLeagues {

    public static void showMenu() throws SQLException {
        while (true) {
            System.out.println("We have the following leagues");
            System.out.println("1) Persian Soccer Club Premier");
            System.out.println("2) Persian Volleyball Club Premier");
            System.out.println("3) Exit");
            System.out.print("Choose one of our league: ");
            String input = ApplicationObjects.getScanner().next();
            if (Objects.equals(input, "1")) {
                ApplicationObjects.getUserService().loadLeague(ApplicationObjects.getPersianSoccerPremierLeague(),
                        new SoccerClub("a", "a"));
                Leagues.showMenu(ApplicationObjects.getPersianSoccerPremierLeague(), new SoccerClub("a", "a"));
            } else if (Objects.equals(input, "2")) {
                ApplicationObjects.getUserService().loadLeague(ApplicationObjects.getPersianVolleyballPremierLeague(),
                        new VolleyballClub("a", "a"));
                Leagues.showMenu(ApplicationObjects.getPersianVolleyballPremierLeague(), new VolleyballClub("a", "a"));
            } else if (Objects.equals(input, "3")) {
                break;
            } else {
                Check.printMessage("Wrong input");
            }
        }
    }

}
