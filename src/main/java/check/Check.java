package check;

public class Check {

    public static void printMessage(String message) {
        System.out.println(message);
        pressEnter();
    }

    private static void pressEnter() {
        System.out.println("Press enter to continue");
        try {
            System.in.read();
        } catch (Exception ignored) {
        }
    }

}
