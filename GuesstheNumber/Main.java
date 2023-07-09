import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int maxAttempts = 5; // Maximum number of attempts allowed

        boolean playAgain = true;
        while (playAgain) {
            int attempts = 0;
            int score = 0;

            int targetNumber = random.nextInt(max - min + 1) + min;

            boolean guessed = false;
            while (!guessed && attempts < maxAttempts) {
                System.out.print("Enter your guess (between " + min + " and " + max + "): ");
                String input = scanner.nextLine();

                if (input.equals("0") || input.equalsIgnoreCase("exit")) {
                    playAgain = false;
                    break;
                }

                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid guess.");
                    continue;
                }

                attempts++;

                if (guess == targetNumber) {
                    guessed = true;
                    score = calculateScore(attempts);
                    System.out.println("\nCongratulations! You guessed the number in " + attempts + " attempts.");
                    System.out.println("Your score: " + score);
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed && playAgain) {
                System.out.println("\nOops! You've reached the maximum number of attempts.");
                System.out.println("The number was: " + targetNumber);
                System.out.println("Score: " + score);

            }

            System.out.println();

            if (playAgain) {
                System.out.print("Do you want to play again? (Enter 'yes' to play again, or 'no' to exit): ");
                String playAgainInput = scanner.nextLine();
                playAgain = playAgainInput.equalsIgnoreCase("yes");
            }
        }

        System.out.println("Thank you for playing Guess the Number!");
        scanner.close();
    }

    private static int calculateScore(int attempts) {
        if(attempts == 1){
            return 100;
        }
        else if (attempts == 2) {
            return  80;
        }
        else if (attempts == 3) {
            return  60;
        }
        else if (attempts == 4) {
            return  40;
        }
        else if (attempts == 5) {
            return  20;
        }else {
            return 0;
        }
    }
}
