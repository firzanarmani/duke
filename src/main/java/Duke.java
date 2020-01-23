import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    private static boolean dukeActive = true;
    private static final Scanner scanner = new Scanner(System.in);
    private static String userInput = "";
    private static String[] items = new String[100];
    private static int itemsCounter = 0;

    /**
     * Main method. Entry point for the Duke program.
     * @param args Command-line arguments. Unused.
     */
    public static void main(final String[] args) {
        final String logo = " ____        _        \n" + "|  _ \\ _   _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n" + "|____/ \\__._|_|\\_\\___|\n";
        final String logoDivider = "++++++++++++++++++++++\n";

        System.out.println(logoDivider + logo + "\n" + logoDivider);

        dukePrompt(new String[]{"Hey boss! Duke here, at your service.", "What do you need me to do?"});
        while (dukeActive) {
            userInput = readUserInput();

            switch (userInput) {
            case "list":
                dukePrompt("Here's what I've written down, boss.");
                listItems();
                break;
            case "bye":
                dukeActive = false;
                dukePrompt("Good bye boss! Call me if you need me. I'll be waiting!");
                break;
            default:
                items[itemsCounter] = userInput;
                dukePrompt("Added: " + userInput);
                itemsCounter++;
                break;
            }
        }
    }

    private static void dukePrompt(String prompt) {
        System.out.println("Duke: " + prompt);
    }

    private static void dukePrompt(String[] prompts) {
        for (int i = 0; i < prompts.length; i++) {
            if (i == 0) {
                System.out.println("Duke: " + prompts[i]);
            } else {
                System.out.println("      " + prompts[i]);
            }
        }
    }

    private static String readUserInput() {
        System.out.printf("You:  ");
        return scanner.nextLine();
    }

    private static void listItems() {
        for (int i = 0; i < itemsCounter; i++) {
            System.out.println("      " + (i + 1) + ". " + items[i]);
        }
    }
}
