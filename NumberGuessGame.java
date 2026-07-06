import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        boolean playAgain = true;

        while (playAgain) {

            printTitle();

            int maxAttempts = chooseDifficulty();

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean guessed = false;

            long startTime = System.currentTimeMillis();

            System.out.println("\nGuess the number between 1 and 100");

            while (attempts < maxAttempts) {

                int guess = getUserGuess();

                attempts++;

                if (guess == secretNumber) {

                    guessed = true;
                    break;
                }

                if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                System.out.println("Attempts Left : " + (maxAttempts - attempts));
            }

            long endTime = System.currentTimeMillis();

            double seconds = (endTime - startTime) / 1000.0;

            System.out.println("\n====================================");

            if (guessed) {

                int score = (maxAttempts - attempts + 1) * 10;

                System.out.println("Congratulations!");
                System.out.println("You guessed the correct number.");
                System.out.println("Secret Number : " + secretNumber);
                System.out.println("Attempts Used : " + attempts);
                System.out.printf("Time Taken    : %.2f seconds%n", seconds);
                System.out.println("Your Score    : " + score);

            } else {

                System.out.println("Game Over!");
                System.out.println("You've used all attempts.");
                System.out.println("Correct Number : " + secretNumber);
            }

            System.out.println("====================================");

            System.out.print("\nPlay Again? (Y/N): ");
            String choice = sc.next();

            playAgain = choice.equalsIgnoreCase("Y");
        }

        System.out.println("\nThank you for playing!");
        System.out.println("Developed for SkillCraft Technology Internship.");

        sc.close();
    }

    static void printTitle() {

        System.out.println("\n=========================================");
        System.out.println("        NUMBER GUESSING GAME");
        System.out.println("=========================================");
    }

    static int chooseDifficulty() {

        while (true) {

            System.out.println("\nChoose Difficulty");
            System.out.println("1. Easy   (10 Attempts)");
            System.out.println("2. Medium (7 Attempts)");
            System.out.println("3. Hard   (5 Attempts)");

            System.out.print("Enter Choice: ");

            try {

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        return 10;

                    case 2:
                        return 7;

                    case 3:
                        return 5;

                    default:
                        System.out.println("Invalid Choice!");

                }

            } catch (InputMismatchException e) {

                System.out.println("Enter numbers only.");
                sc.next();
            }
        }
    }

    static int getUserGuess() {

        while (true) {

            try {

                System.out.print("\nEnter Guess : ");

                int guess = sc.nextInt();

                if (guess < 1 || guess > 100) {

                    System.out.println("Enter a number between 1 and 100.");

                } else {

                    return guess;
                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid Input! Numbers only.");
                sc.next();
            }
        }
    }
}