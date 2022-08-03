package check;

import entity.Club;
import object.ApplicationObjects;

import java.util.Objects;
import java.util.regex.Pattern;

public class Check {

    public void printMessage(String message) {
        System.out.println(message);
        pressEnter();
    }

    public String checkSet(String set) {
        String regex = "\\d";
        while (true) {
            if (Pattern.matches(regex, set)) {
                if (Objects.equals(set, "0") || Objects.equals(set, "1") || Objects.equals(set, "2"))
                    return set;
                else {
                    System.out.print("Wrong number. Enter 1 or 2 or 3: ");
                    set = ApplicationObjects.getScanner().next();
                }
            } else {
                System.out.print("Wrong input. Enter again: ");
                set = ApplicationObjects.getScanner().next();
            }
        }
    }

    public boolean checkSameClubForGame(Club clubOne, Club clubTwo) {
        return clubOne.equals(clubTwo);
    }

    public int checkLeagueExists(String input, int number) {
        while (true){
            if (Pattern.matches("\\d*", input)) {
                if (Integer.parseInt(input) <= number + 3)
                    return Integer.parseInt(input);
                else{
                    System.out.print("This number is not in our items. choose again: ");
                    input = ApplicationObjects.getScanner().next();
                }
            }
            else{
                System.out.print("Wrong input. Enter number: ");
                input = ApplicationObjects.getScanner().next();
            }
        }
    }

    public String checkTypeClub(String type){
        while(true){
            if(Objects.equals(type.toLowerCase(), "soccer") || Objects.equals(type.toLowerCase(), "volleyball")){
                return type;
            } else{
                System.out.print("We don't have this kind of club now");
                System.out.print("Try again: ");
                type = ApplicationObjects.getScanner().next();
            }
        }
    }

    private void pressEnter() {
        System.out.println("Press enter to continue");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }

}
