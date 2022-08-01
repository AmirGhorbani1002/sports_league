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

    public void showTable(League league){
        Arrays.sort(league.getClubs().getClubs(), new ClubListSortByScore());
        for (Club club1 : league.getClubs().getClubs())
            System.out.println(club1);
    }

    public void showClub(League league){
        System.out.print("Enter the name of the club you want to see: ");
        String name = ApplicationObjects.getScanner().nextLine();
        System.out.println(ApplicationObjects.getUserService().loadClub(league, name));
    }

    public void addClub(League league,Club checkType){
        ApplicationObjects.getScanner().nextLine();
        String name = ApplicationObjects.getScanner().nextLine();
        String code = ApplicationObjects.getScanner().nextLine();
        ApplicationObjects.getUserService().saveClub(league, checkType, name, code);
    }

    public void deleteClub(League league){
        String name = ApplicationObjects.getScanner().nextLine();
        ApplicationObjects.getUserService().deleteClub(league, name);
    }

    public void addGame(League league,Club checkType){
        System.out.print("Enter the name of first club: ");
        String nameOne = ApplicationObjects.getScanner().nextLine();
        Club clubOne = ApplicationObjects.getUserService().loadClub(league, nameOne);
        System.out.print("Enter the name of second club: ");
        String nameTwo = ApplicationObjects.getScanner().nextLine();
        Club clubTwo = ApplicationObjects.getUserService().loadClub(league, nameTwo);
        gameCalculate(league, checkType, nameOne, clubOne, clubTwo);
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
            System.out.print("How many sets did " + clubTwo + "'s club win?");
            String numberOfWinSet = ApplicationObjects.getScanner().next();
            ((VolleyballClub) clubTwo).setNumberOfWinningSets(Integer.parseInt(numberOfWinSet));
            ApplicationObjects.getUserService().addGame(league, clubOne, clubTwo, GameResult.WIN);
        } else {
            System.out.print("How many sets did " + clubOne + "'s club win?");
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
