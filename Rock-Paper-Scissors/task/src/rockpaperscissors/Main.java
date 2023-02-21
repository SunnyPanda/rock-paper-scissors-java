package rockpaperscissors;

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

        String user = in.next();
        while (!user.equals("!exit")) {
            if (!options.contains(user)) System.out.println("Invalid input");
            else {
                int index = random.nextInt(3);
                String comp = options.get(index);

                if (user.equals(comp)) System.out.printf("There is a draw (%s)\n", user);
                else if (comp.equals(bits.get(user))) System.out.printf("Well done. The computer chose %s and failed\n", comp);
                else System.out.printf("Sorry, but the computer chose %s\n", comp);
            }
            user = in.next();
        }
    }
}
