package service;

import entity.Club;
import entity.League;
import entity.SoccerClub;
import entity.VolleyballClub;
import enums.GameResult;
import list.sort.ClubListSortByScore;
import object.ApplicationObjects;

import java.util.Arrays;
import java.util.Objects;

public class UserMethods {

    public void showTable(League league) {
        Arrays.sort(league.getClubs().getClubs(), new ClubListSortByScore());
        ApplicationObjects.getUserService().showTable(league);
    }

    public void showClub(League league) {
        if (league.getClubs().getClubs()[0] == null) {
            System.out.println("This league does not have any clubs yet");
        } else {
            System.out.print("Enter the name of the club you want to see: ");
            ApplicationObjects.getScanner().nextLine();
            String name = ApplicationObjects.getScanner().nextLine();
            if (ApplicationObjects.getUserService().loadClubByName(league, name) != null)
                System.out.println(ApplicationObjects.getUserService().loadClubByName(league, name));
            else {
                System.out.println("There is no club with this name");
            }
        }

    }

    public void addClub(League league, Club checkType) {
        ApplicationObjects.getScanner().nextLine();
        System.out.print("Enter the name of your club: ");
        String name = ApplicationObjects.getScanner().nextLine();
        System.out.print("Enter the code of your club: ");
        String code = ApplicationObjects.getScanner().nextLine();
        ApplicationObjects.getUserService().saveClub(league, checkType, name, code);
    }

    public void deleteClub(League league) {
        ApplicationObjects.getScanner().nextLine();
        String name = ApplicationObjects.getScanner().nextLine();
        ApplicationObjects.getUserService().deleteClub(league, name);
    }

    public void addGame(League league, Club checkType) {
        if (league.getClubs().getClubs()[0] == null || league.getClubs().getClubs()[1] == null) {
            System.out.println("This league does not have enough clubs for game yet");
        } else {
            while (true) {
                System.out.print("Enter the name of first club: ");
                ApplicationObjects.getScanner().nextLine();
                String nameOne = ApplicationObjects.getScanner().nextLine();
                Club clubOne = getClub(league, nameOne);
                if (clubOne == null) continue;
                System.out.print("Enter the name of second club: ");
                String nameTwo = ApplicationObjects.getScanner().nextLine();
                Club clubTwo = getClub(league, nameTwo);
                if (clubTwo == null) continue;
                gameCalculate(league, checkType, nameOne, clubOne, clubTwo);
                break;
            }
        }
    }

    private Club getClub(League league, String nameOne) {
        Club clubOne = ApplicationObjects.getUserService().loadClubByName(league, nameOne);
        if (clubOne == null) {
            System.out.println("There is no club with this name");
            return null;
        }
        return clubOne;
    }

    private void gameCalculate(League league, Club checkType, String nameOne, Club clubOne, Club clubTwo) {
        if (checkType instanceof SoccerClub) {
            System.out.print("Did " + nameOne + " club win? (Enter yes or no or draw)");
            String result = ApplicationObjects.getScanner().next();
            soccerGameMods(league, clubOne, clubTwo, result);
        } else {
            System.out.print("Did " + nameOne + " club win? (Enter yes or no)");
            String result = ApplicationObjects.getScanner().next();
            volleyballGameMods(league, clubOne, clubTwo, result);
        }
    }

    private void volleyballGameMods(League league, Club clubOne, Club clubTwo, String result) {
        if (Objects.equals(result, "yes")) {
            System.out.print("How many sets did " + clubTwo.getName() + "'s club win?");
            String numberOfWinSet = ApplicationObjects.getScanner().next();
            ((VolleyballClub) clubTwo).setNumberOfWinningSets(Integer.parseInt(numberOfWinSet));
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.WIN);
        } else {
            System.out.print("How many sets did " + clubOne.getName() + "'s club win?");
            String numberOfWinSet = ApplicationObjects.getScanner().next();
            ((VolleyballClub) clubOne).setNumberOfWinningSets(Integer.parseInt(numberOfWinSet));
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.LOSS);
        }
    }

    private void soccerGameMods(League league, Club clubOne, Club clubTwo, String result) {
        if (Objects.equals(result, "yes"))
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.WIN);
        else if (Objects.equals(result, "no"))
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.LOSS);
        else
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.DRAW);
    }
}
