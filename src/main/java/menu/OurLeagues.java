package menu;

import entity.SoccerClub;
import object.ApplicationObjects;

import java.sql.SQLException;
import java.util.Objects;

public class OurLeagues {

    public static void showMenu() throws SQLException {
        System.out.println("We have the following leagues");
        System.out.println("1) Persian Soccer Club Premier");
        System.out.println("2) Volleyball league");
        System.out.print("Choose one of our league: ");
        String input = ApplicationObjects.getScanner().next();
        if (Objects.equals(input, "1")) {
            LeaguesMenu.showMenu(ApplicationObjects.getPersianSoccerClubPremier(), new SoccerClub("a","a"));
        }
    }

}
