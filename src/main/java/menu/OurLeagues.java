package menu;

import entity.SoccerClub;
import entity.VolleyballClub;
import object.ApplicationObjects;

import java.sql.SQLException;
import java.util.Objects;

public class OurLeagues {

    public static void showMenu() throws SQLException {
        while (true){
            System.out.println("We have the following leagues");
            System.out.println("1) Persian Soccer Club Premier");
            System.out.println("2) Persian Volleyball Club Premier");
            System.out.println("3) Exit");
            System.out.print("Choose one of our league: ");
            String input = ApplicationObjects.getScanner().next();
            if (Objects.equals(input, "1")) {
                League.showMenu(ApplicationObjects.getPersianSoccerClubPremier(), new SoccerClub("a","a"));
            } else if(Objects.equals(input, "2")){
                League.showMenu(ApplicationObjects.getPersianVolleyballClubPremier(), new VolleyballClub("a","a"));
            } else if(Objects.equals(input, "3")){
                break;
            } else{
                System.out.println("Wrong input");
            }
        }
    }

}
