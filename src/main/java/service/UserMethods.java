package service;

import check.Check;
import entity.Club;
import entity.League;
import entity.VolleyballClub;
import enums.GameResult;
import util.sort.ClubListSortByScore;
import object.ApplicationObjects;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

public class UserMethods {

    Check check = new Check();

    public void showTable(League league) {
        Arrays.sort(league.getClubs().getClubs(), new ClubListSortByScore());
        ApplicationObjects.getUserService().showTable(league);
    }

    public void showClub(League league) {
        if (league.getClubs().getClubs()[0] == null) {
            check.printMessage("This league does not have any clubs yet");
        } else {
            System.out.print("Enter the name of the club you want to see: ");
            ApplicationObjects.getScanner().nextLine();
            String name = ApplicationObjects.getScanner().nextLine();
            if (ApplicationObjects.getUserService().loadClubByName(league, name) != null) {
                System.out.println(ApplicationObjects.getUserService().loadClubByName(league, name));
                check.printMessage("");
            } else {
                check.printMessage("There is no club with this name");
            }
        }
    }

    public void addClub(League league, String checkType) throws SQLException {
        ApplicationObjects.getScanner().nextLine();
        System.out.print("Enter the name of your club: ");
        String name = ApplicationObjects.getScanner().nextLine();
        System.out.print("Enter the code of your club: ");
        String code = ApplicationObjects.getScanner().nextLine();
        ApplicationObjects.getUserService().saveClub(league, checkType, name, code);
        check.printMessage("Add club done!");
    }

    public void deleteClub(League league) {
        ApplicationObjects.getScanner().nextLine();
        System.out.print("Enter the name of your club: ");
        String name = ApplicationObjects.getScanner().nextLine();
        ApplicationObjects.getUserService().deleteClub(league, name);
        check.printMessage("Delete club done!");
    }

    public void addGame(League league, String checkType) throws SQLException {
        if (league.getClubs().getClubs()[0] == null || league.getClubs().getClubs()[1] == null) {
            check.printMessage("This league does not have enough clubs for game yet");
        } else {
            System.out.print("Enter the name of first club: ");
            ApplicationObjects.getScanner().nextLine();
            String nameOne = ApplicationObjects.getScanner().nextLine();
            Club clubOne = checkClub(league, nameOne);
            if (clubOne == null) return;
            System.out.print("Enter the name of second club: ");
            String nameTwo = ApplicationObjects.getScanner().nextLine();
            Club clubTwo = checkClub(league, nameTwo);
            if (clubTwo == null) return;
            if (check.checkSameClubForGame(clubOne, clubTwo)) {
                check.printMessage("A club cannot play with itself!!!");
                return;
            }
            gameCalculate(league, checkType, nameOne, clubOne, clubTwo);
            check.printMessage("Add game done!");
        }
    }

    public void addLeague() throws SQLException {
        System.out.print("Enter the name of league: ");
        ApplicationObjects.getScanner().nextLine();
        String name = ApplicationObjects.getScanner().nextLine();
        System.out.print("Enter the type of league's clubs: (For now we only have soccer and volleyball) ");
        String type = check.checkTypeClub(ApplicationObjects.getScanner().next());
        ApplicationObjects.getUserService().addLeague(name, type);
        check.printMessage("Add league done!");
    }

    public void deleteLeague() throws SQLException {
        System.out.println("Enter the name of league: ");
        ApplicationObjects.getScanner().nextLine();
        String name = ApplicationObjects.getScanner().nextLine();
        System.out.println(name);
        System.out.print("Are you sure? So enter confirm to continue: ");
        String confirm = ApplicationObjects.getScanner().nextLine();
        if (Objects.equals(confirm, "confirm"))
            ApplicationObjects.getUserService().deleteLeague(name);
        check.printMessage("Delete league done!");
    }

    private Club checkClub(League league, String name) {
        Club club = ApplicationObjects.getUserService().loadClubByName(league, name);
        if (club == null) {
            check.printMessage("There is no club with this name");
            return null;
        }
        return club;
    }

    private void gameCalculate(League league, String checkType, String nameOne, Club clubOne, Club clubTwo) throws SQLException {
        if (Objects.equals(checkType, "soccer")) {
            System.out.print("Did " + nameOne + " club win? (Enter yes or no or draw) ");
            String result = ApplicationObjects.getScanner().next();
            soccerGameMods(league, clubOne, clubTwo, result);
        } else {
            System.out.print("Did " + nameOne + " club win? (Enter yes or no) ");
            String result = ApplicationObjects.getScanner().next();
            volleyballGameMods(league, clubOne, clubTwo, result);
        }
    }

    private void volleyballGameMods(League league, Club clubOne, Club clubTwo, String result) throws SQLException {
        if (Objects.equals(result, "yes")) {
            System.out.print("How many sets did " + clubTwo.getName() + "'s club win? ");
            String numberOfWinSet = ApplicationObjects.getScanner().next();
            numberOfWinSet = check.checkSet(numberOfWinSet);
            ((VolleyballClub) clubTwo).setNumberOfWinningSets(Integer.parseInt(numberOfWinSet));
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.WIN);
        } else {
            System.out.print("How many sets did " + clubOne.getName() + "'s club win? ");
            String numberOfWinSet = ApplicationObjects.getScanner().next();
            numberOfWinSet = check.checkSet(numberOfWinSet);
            ((VolleyballClub) clubOne).setNumberOfWinningSets(Integer.parseInt(numberOfWinSet));
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.LOSS);
        }
    }

    private void soccerGameMods(League league, Club clubOne, Club clubTwo, String result) throws SQLException {
        if (Objects.equals(result, "yes"))
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.WIN);
        else if (Objects.equals(result, "no"))
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.LOSS);
        else
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.DRAW);
    }

    private void pressEnter() {
        System.out.println("Press enter to continue");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }
}
