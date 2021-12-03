/*
 * This program allows the user to play rock paper scissors with the computer.
 *
 * @author  Ryan Chung
 * @version 1.0
 * @since   2021-12-02
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
* This class generates a random number and asks the user to guess it.
*/
final class RockPaperScissors {

    /**
    * Prevents instantiation.
    * Throw an exception IllegalStateException when called.
    *
    * @throws IllegalStateException
    *
    */
    private RockPaperScissors() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Generates the random bot choice.
    *
    * @return This function returns the random choice of the computer.
    *
    */
    private static String botChoice() {

        final String rock = "rock";
        final String paper = "paper";
        final String scissors = "scissors";

        final int lowerNum = 0;
        final int higherNum = 2;

        final int randomInt = new Random().nextInt(higherNum) + lowerNum;
        String botChoice = "";

        switch (randomInt) {
            case 0:
                botChoice = rock;
                break;
            case 1:
                botChoice = paper;
                break;
            case 2:
                botChoice = scissors;
                break;
            default:
                break;
        }

        return botChoice;
    }

    /**
    * Checks to see who won the game.
    *
    * @param userChoice is the user input.
    * @param botChoice is the computer's random choice.
    * @return This function returns the random choice of the computer.
    *
    */
    private static String whoWins(
            final String userChoice, final String botChoice) {

        final String rock = "rock";
        final String paper = "paper";
        final String scissors = "scissors";

        final String whoWins;

        if (userChoice.equals(botChoice)) {
            whoWins = "Tie. ";
        } else if (rock.equals(userChoice) && scissors.equals(botChoice)
                   || scissors.equals(userChoice) && paper.equals(botChoice)
                   || paper.equals(userChoice) && rock.equals(botChoice)) {

            whoWins = "You win! ";
        } else {
            whoWins = "You lose :( ";
        }

        return whoWins;
    }

    /**
     * Grabs user input, validates it, checks and displays who won
     * between a random bot choice and the user.
     *
     * @param args No args will be used.
     * @throws IOException if there is anything wrong with the user input.
     *
     * */
    public static void main(final String[] args) {

        final String rock = "rock";
        final String paper = "paper";
        final String scissors = "scissors";

        final String userChoice;
        final String botChoice;
        final String whoWins;

        try {
            // User prompt
            System.out.print("Enter rock, paper or scissors: ");

            // Gathers and parses input to a String
            userChoice = new BufferedReader(
                    new InputStreamReader(System.in)
            ).readLine().toLowerCase();

            switch (userChoice) {
                case rock: break;
                case paper: break;
                case scissors: break;
                default: throw new IOException();
            }

            botChoice = botChoice();

            whoWins = whoWins(userChoice, botChoice);
            System.out.println(
                    whoWins + "The computer's choice was " + botChoice + ".");

        } catch (IOException exception) {
            // Outputs error message
            System.out.println("Please enter a correct input.");
        }

        System.out.println("\nDone.");
    }

}

