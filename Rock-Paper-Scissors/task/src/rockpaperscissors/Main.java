package rockpaperscissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> bits = new HashMap<>();
        bits.put("rock", "scissors");
        bits.put("paper", "rock");
        bits.put("scissors", "paper");
        List<String> options = List.of("rock", "paper", "scissors");

        Scanner in = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter your name: ");
        String name = in.next();
        System.out.printf("Hello, %s\n", name);

        int rating = 0;
        File file = new File("./rating.txt");
        try (Scanner inFile = new Scanner(file)) {
            while (inFile.hasNext()) {
                if (inFile.next().equals(name)) rating = inFile.nextInt();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        String user = in.next();
        while (!user.equals("!exit")) {
            if (user.equals("!rating")) System.out.printf("Your rating: %d\n", rating);
            else if (!options.contains(user)) System.out.println("Invalid input");
            else {
                int index = random.nextInt(3);
                String comp = options.get(index);

                if (user.equals(comp)) {
                    System.out.printf("There is a draw (%s)\n", user);
                    rating += 50;
                }
                else if (comp.equals(bits.get(user))) {
                    System.out.printf("Well done. The computer chose %s and failed\n", comp);
                    rating += 100;
                }
                else System.out.printf("Sorry, but the computer chose %s\n", comp);
            }
            user = in.next();
        }


    }
}
