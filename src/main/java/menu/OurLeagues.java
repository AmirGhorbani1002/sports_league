package menu;

import object.ApplicationObjects;

import java.util.Objects;

public class OurLeagues {

    public static void showMenu(){
        System.out.println("We have the following leagues");
        System.out.println("1) Soccer league");
        System.out.println("2) Volleyball league");
        System.out.print("Choose one of our league: ");
        String input = ApplicationObjects.getScanner().next();
        if(Objects.equals(input, "1")){

        }
    }

}
