import java.util.ArrayList;
import java.util.Scanner;

// This is the Demo for chaging the code
/*
This is the guesser class which guess the number it contains one variable and one method
Variable stores the guessed num
Method ask the guesser for number and store that number in variable
*/
class Guesser {
    int guessedNum;// This variable stores the guessed num
    // This method asks the guesser to enter the number which player's have to be
    // guessed, and return it to the umpire

    int guessingNumber() {
        System.out.println("Guesser kindly guess the number");
        Scanner sc = new Scanner(System.in);
        guessedNum = sc.nextInt();
        NumGuess.printStar();
        return guessedNum;
    }
}

/*
 * The Player class contains a variable and a method.
 * Variable store the guessed number, guessed by the player.
 * Method ask user to enter their guessed number.
 */
class Player {
    String name; // This will store the player's name
    int guessNum;// Store the guessed number
    // The method ask player to enter their guessed number. And return the guessed
    // num to the umpire

    Player(Scanner sc) {
        System.out.println("Player Kindly Enter Your Name : ");
        name = sc.nextLine();
        NumGuess.printStar();
    }

    int guessingNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player kindly guess the number");
        guessNum = sc.nextInt();
        NumGuess.printStar();
        return guessNum;
    }

    @Override
    public String toString() {
        return name + " ";
    }
}

/*
 * The class Umpire contains the Guessed number, by the guesser and players.
 * The umpire compare the guessed number of guesser and players if players
 * guessed number match then it announces the winner name
 */
class Umpire {
    Scanner sc = new Scanner(System.in);
    int guesserNum;// Stores the guesser number
    int player1Num;// Stores the Player1 number

    int player2Num;// Stores the Player2 number
    int player3Num;// Stores the Player 3 number
    int[] score = { 0, 0, 0 };
    Player p1, p2, p3;

    void createPlayers() {
        p1 = new Player(sc);
        NumGuess.playersName.add(p1);
        p2 = new Player(sc);
        NumGuess.playersName.add(p2);
        p3 = new Player(sc);
        NumGuess.playersName.add(p3);
    }

    /*
     * The method collectNumberFromGuesser() asks the guesser to guess the number
     */
    void collectNumberFromGuesser() {
        Guesser g = new Guesser();
        guesserNum = g.guessingNumber();
    }

    /*
     * The method collectNumberFromPlayer() collect number from Player and store the
     * number to their corresponding variable
     */
    void collectNumberFromPlayer() {

        player1Num = p1.guessingNumber();
        player2Num = p2.guessingNumber();
        player3Num = p3.guessingNumber();
    }

    /*
     * This method compare(), compare the players value and guesser value and
     * announce the final winner.
     */
    void compare() {
        if (player1Num == guesserNum) {
            if (player2Num == guesserNum && player3Num == guesserNum) {
                score[0] += 1;
                score[1] += 1;
                score[2] += 1;
                System.out.println("Sab Jit Gaye Hurrah!");
                NumGuess.printStar();
            } else if (player2Num == guesserNum) {
                score[0] += 1;
                score[2] += 1;
                System.out.println("Pahle Aur Dusre Ne Jita");
                NumGuess.printStar();
            } else if (player3Num == guesserNum) {
                score[0] += 1;
                score[2] += 1;
                System.out.println("Pahle Aur Tisre ne Jita");
                NumGuess.printStar();
            } else {
                score[0] += 1;
                System.out.println("Sirf Pahle ne Jita");
                NumGuess.printStar();
            }
        } else if (player2Num == guesserNum) {
            if (player3Num == guesserNum) {
                score[1] += 1;
                score[2] += 1;
                System.out.println("Dusre Aur tisre ne jita");
                NumGuess.printStar();
            } else {
                score[1] += 1;
                System.out.println("Sirf Dusre ne jita");
                NumGuess.printStar();
            }
        } else if (player3Num == guesserNum) {
            score[2] += 1;
            System.out.println("Sirf Tisre ne jita");
            NumGuess.printStar();
        } else {
            System.out.println("Sab Galat Hai, Best Of Luck ");
            NumGuess.printStar();
        }
    }

    int[] returnScore() {
        return score;
    }
}

public class NumGuess {
    public static ArrayList<Player> playersName = new ArrayList<>();

    public static void printStar() {
        System.out.println("**************************************************\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\tGame Start\n");
        printStar();
        char choice;
        Umpire u = new Umpire();
        u.createPlayers();
        do {
            u.collectNumberFromGuesser();
            u.collectNumberFromPlayer();
            u.compare();
            System.out.println("Wants to play more? y for yes or press any key to exit");
            choice = sc.next().charAt(0);
            printStar();
        } while (choice == 'y');
        printStar();
        System.out.println("*************** Score Board ***************");
        int[] score = u.returnScore();
        for (Player p : playersName) {
            System.out.print(p + "\t");
        }
        System.out.println();
        for (int i : score) {
            {
                System.out.print(i + "\t");
            }
        }
    }
}
