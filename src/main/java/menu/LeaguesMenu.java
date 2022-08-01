package menu;

import entity.Club;
import entity.League;
import list.ClubListSortByScore;
import object.ApplicationObjects;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class LeaguesMenu {

    public static void showMenu(League league, Club club) throws SQLException {
        while (true) {
            System.out.println("1) View table");
            System.out.println("2) View information about a club");
            System.out.println("3) Add club");
            System.out.println("4) Remove club");
            System.out.println("5) Add game");
            System.out.println("6) Exit");
            System.out.print("Choose on of the items: ");
            String input = ApplicationObjects.getScanner().next();
            if (Objects.equals(input, "1")) {
                Arrays.sort(league.getClubs().getClubs(),new ClubListSortByScore());
                for (Club club1 : league.getClubs().getClubs())
                    System.out.println(club1);
            } else if (Objects.equals(input, "2")) {

            } else if (Objects.equals(input, "3")) {
                ApplicationObjects.getUserService().addClub(league, club);
            } else if (Objects.equals(input, "4")) {

            } else if (Objects.equals(input, "5")) {

            } else if (Objects.equals(input, "6")) {
                break;
            }
        }

    }

}
