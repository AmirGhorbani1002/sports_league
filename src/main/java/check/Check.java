package check;

import object.ApplicationObjects;

import java.util.Objects;
import java.util.regex.Pattern;

public class Check {

    public static void printMessage(String message) {
        System.out.println(message);
        pressEnter();
    }

    public static String checkSet(String set) {
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

    private static void pressEnter() {
        System.out.println("Press enter to continue");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }

}
