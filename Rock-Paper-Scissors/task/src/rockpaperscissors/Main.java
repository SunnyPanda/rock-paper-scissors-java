package rockpaperscissors;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<String, String> bits = new HashMap<>();
        bits.put("rock", "scissors");
        bits.put("paper", "rock");
        bits.put("scissors", "paper");
        String[] options = new String[]{"rock", "paper", "scissors"};

        Scanner in = new Scanner(System.in);
        String user = in.next();

        Random random = new Random();
        int index = random.nextInt(3);
        String comp = options[index];

        if (user.equals(comp)) System.out.printf("There is a draw (%s)", user);
        else if (comp.equals(bits.get(user))) System.out.printf("Well done. The computer chose %s and failed", comp);
        else System.out.printf("Sorry, but the computer chose %s", comp);
    }
}
