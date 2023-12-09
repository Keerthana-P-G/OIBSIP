//  NUMBER GUESSING GAME  //


import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 1;
        int upperBound = 100;
        int numberOfRounds = 3;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        for (int round = 1; round <= numberOfRounds; round++) {
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int attempts = 0;
            int maxAttempts = 7;

            System.out.println("\nRound " + round + ":");
            System.out.println("Try to guess the number between " + lowerBound + " and " + upperBound);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Round Score: " + roundScore);
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                if (attempts == maxAttempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + generatedNumber);
                }
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);

        scanner.close();
    }
}
