import javax.swing.*;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {

        int computerNumber = (int) (Math.random()*100 +1);
        int userGuess = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int guessesCount = 1;

        while (userGuess != computerNumber){
            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100", "Guessing Game", 3);
            userGuess = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null, ""
                                            + determineGuess(userGuess, computerNumber, guessesCount));
            guessesCount++;
        }
    }

    public static String determineGuess(int usersGuess, int computersNumber, int countOfGuess){

        if (usersGuess < 1 || usersGuess > 100){
           return "Your guess is not in the range of 1 to 100, guess again within this range";
        }
        if (usersGuess == computersNumber){
            return "Congratulations you got there in " + countOfGuess + " guesses";
        }
        if (usersGuess > computersNumber) {
            return "Your guess is higher than the computers number, try again! \n Number of guesses so far: "
                    + countOfGuess;
        }
        if (usersGuess < computersNumber){
            return "Your guess is lower than the computers number, try again! \n Number of guesses so far: "
                    + countOfGuess;
        }
        else {
            return "Your guess is incorrect, try again! \n Number of guesses so far " + countOfGuess;
        }
    }
}
