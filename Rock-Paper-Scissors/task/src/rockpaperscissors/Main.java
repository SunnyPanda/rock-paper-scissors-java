package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        String name = in.next();
        System.out.printf("Hello, %s\n", name);

        List<String> options = getListOfOptions();
        System.out.println("Okay, let's start");

        int rating = getRating(name);

        Random random = new Random();
        String user = in.next();
        while (!user.equals("!exit")) {
            if (user.equals("!rating")) System.out.printf("Your rating: %d\n", rating);
            else if (!options.contains(user)) System.out.println("Invalid input");
            else {
                int index = random.nextInt(options.size());
                String comp = options.get(index);
                List<String> restOptions = new ArrayList<>();
                int start = options.indexOf(user) == options.size() - 1 ? 0 : options.indexOf(user) + 1;
                for (int i = start; restOptions.size() < options.size() - 1; i++) {
                    restOptions.add(options.get(i));
                    if (i == options.size() - 1) i = -1;
                }

                if (user.equals(comp)) {
                    System.out.printf("There is a draw (%s)\n", user);
                    rating += 50;
                }
                else if (restOptions.indexOf(comp) >= restOptions.size() / 2 ) {
                    System.out.printf("Well done. The computer chose %s and failed\n", comp);
                    rating += 100;
                }
                else System.out.printf("Sorry, but the computer chose %s\n", comp);
            }
            user = in.next();
        }
    }

    private static List<String> getListOfOptions() {
        List<String> defaultOptions = List.of("rock", "paper", "scissors");
        in.nextLine();
        List<String> inputOptions = Arrays.stream(in.nextLine().split(",")).filter(str -> !str.isEmpty()).toList();
        return inputOptions.isEmpty() ? defaultOptions : inputOptions;
    }

    private static int getRating(String name) {
        int rating = 0;
        File file = new File("./rating.txt");
        try (Scanner inFile = new Scanner(file)) {
            while (inFile.hasNext()) {
                if (inFile.next().equals(name)) rating = inFile.nextInt();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return rating;
    }
}
