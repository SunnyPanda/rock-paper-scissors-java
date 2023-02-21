package rockpaperscissors;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        switch (in.next()) {
            case "rock" -> System.out.println("Sorry, but the computer chose paper");
            case "paper" -> System.out.println("Sorry, but the computer chose scissors");
            case "scissors" -> System.out.println("Sorry, but the computer chose rock");
        }
    }
}
