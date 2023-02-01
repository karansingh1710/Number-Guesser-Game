import java.util.Scanner;
/*
This is the guesser class which guess the number it contains one variable and one method
Variable stores the guessed num
Method ask the guesser for number and store that number in variable
*/
class Guesser{
    int guessedNum;//This variable stores the guessed num
    //This method asks the guesser to enter the number which player's have to be guessed, and return it to the umpire
   int guessingNumber(){
        System.out.println("Guesser kindly guess the number");
        Scanner sc=new Scanner(System.in);
        guessedNum=sc.nextInt();
        return guessedNum;
    }
}
/*
The Player class contains a variable and a method.
Variable store the guessed number, guessed by the player.
Method ask user to enter their guessed number.
 */
class Player {
    int guessNum;//Store the guessed number
//The method ask player to enter their guessed number. And return the guessed num to the umpire
    int guessingNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Player kindly guess the num");
        guessNum = sc.nextInt();
        return guessNum;
    }
}
/*
The class Umpire contains the Guessed number, by the guesser and players.
The umpire compare the guessed number of guesser and players if players guessed number match then it announces the winner name
 */
    class Umpire {
        int guesserNum;//Stores the guesser number
        int player1Num;//Stores the Player1 number

        int player2Num;//Stores the Player2 number
        int player3Num;//Stores the Player 3 number
    int[] score={0,0,0};
/*
The method collectNumberFromGuesser() asks the guesser to guess the number
 */
        void collectNumberFromGuesser() {
            Guesser g = new Guesser();
            guesserNum = g.guessingNumber();
        }
/*
The method collectNumberFromPlayer() collect number from Player and store the number to their corresponding variable
 */
        void collectNumberFromPlayer() {
            Player p1 = new Player();
            Player p2 = new Player();
            Player p3=new Player();
            player1Num = p1.guessingNumber();
            player2Num = p2.guessingNumber();
            player3Num = p3.guessingNumber();
        }
/*
This method compare(), compare the players value and guesser value and announce the final winner.
 */
        void compare() {
            if (player1Num == guesserNum) {
                if (player2Num==guesserNum&&player3Num==guesserNum){
                    score[0]+=1; score[1]+=1; score[2]+=1;
                    System.out.println("Sab Jit Gaye Hurrah!");
                } else if (player2Num==guesserNum) {
                    score[0]+=1; score[2]+=1;
                    System.out.println("Pahle Aur Dusre Ne Jita");
                } else if (player3Num==guesserNum) {
                    score[0]+=1; score[2]+=1;
                    System.out.println("Pahle Aur Tisre ne Jita");
                }
                else {
                    score[0]+=1;
                    System.out.println("Sirf Pahle ne Jita");
                }
            }
            else if (player2Num == guesserNum) {
                if (player3Num==guesserNum){
                    score[1]+=1; score[2]+=1;
                    System.out.println("Dusre Aur tisre ne jita");
                }
                else {
                    score[1]+=1;
                    System.out.println("Sirf Dusre ne jita");
                }
                }
            else if (player3Num==guesserNum) {
                score[2]+=1;
                System.out.println("Sirf Tisre ne jita");
            }
            else {
                System.out.println("Sab Galat Hai, Best Of Luck ");
            }
        }
        int[] returnScore(){
            return score;
        }
    }
public class NumGuess {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Game Start");
        char choice;
        Umpire u=new Umpire();
        do {
            u.collectNumberFromGuesser();
            u.collectNumberFromPlayer();
            u.compare();
            System.out.println("Wants to play more? y for yes or press any key to exit");
            choice=sc.next().charAt(0);
        }while (choice=='y');
        int[] score=u.returnScore();
        for(int i=0; i<score.length; i++){
            System.out.println("Player"+(i+1)+" "+score[i]);
        }
    }
}
