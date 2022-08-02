package view;

import check.Check;
import entity.Club;
import object.ApplicationObjects;

import java.sql.SQLException;
import java.util.Objects;

public class Leagues {

    public void showMenu(entity.League league, Club checkType) throws SQLException {
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
                ApplicationObjects.getUserMethods().showTable(league);
            } else if (Objects.equals(input, "2")) {
                ApplicationObjects.getUserMethods().showClub(league);
            } else if (Objects.equals(input, "3")) {
                ApplicationObjects.getUserMethods().addClub(league, checkType);
            } else if (Objects.equals(input, "4")) {
                ApplicationObjects.getUserMethods().deleteClub(league);
            } else if (Objects.equals(input, "5")) {
                ApplicationObjects.getUserMethods().addGame(league, checkType);
            } else if (Objects.equals(input, "6")) {
                break;
            } else {
                Check.printMessage("Wrong input");
            }
        }
    }
}
