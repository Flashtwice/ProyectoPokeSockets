package co.edu.unbosque.view;
import java.util.Scanner;

public class ConsoleUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void printHeader(String header) {
        System.out.println("=====================================");
        System.out.println(header.toUpperCase());
        System.out.println("=====================================");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println("ERROR: " + errorMessage);
    }

    public static int readInteger(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + ": ");
                String input = scanner.nextLine();
                int result = Integer.parseInt(input);
                return result;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please enter an integer");
            }
        }
    }

    public static String readString(String prompt) {
        System.out.print(prompt + ": ");
        String input = scanner.nextLine();
        return input;
    }

}

