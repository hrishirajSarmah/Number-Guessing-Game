
import java.util.Random;
import java.util.Scanner;
public class NumberGame {
    //Random rand = new Random();
    public static int randomNumber;

    public static int getRandomNumber() {
        return randomNumber;
    }

    public static void setRandomNumber(int randomNumber) {
        NumberGame.randomNumber = randomNumber;
    }

    public static void main(String[] args){

        System.out.println("~~NUMBER GAME~~");
        System.out.println("Rules: \n" +
                "1. Select number of rounds you wanna play. \n" +
                "2. You will get 5 attempts per round. \n" +
                "3. Each round has 5 points. If you answer in 1st attempt, you get 5 points, 2nd attempt 4 points and so on. \n" +
                "4. At the end the total score is calculated. After all rounds. \n" +
                "5. For each round a new random number is generated between 1-100.");
        int roundEntered;
        Scanner roundInput = new Scanner(System.in);
        System.out.println("Enter Number of Rounds: ");
        roundEntered = roundInput.nextInt();

        NumberGame game1 = new NumberGame();
        game1.rounds(roundEntered);

    }

    public void rounds(int round) {
        int score=0;
        for (int i = 1; i <= round; i++) {
            Random rand = new Random();
            NumberGame.setRandomNumber(rand.nextInt(100));

            Scanner numEntered = new Scanner(System.in);

            System.out.println("Generating random number .....");
            int count = 5, points=0;
            while (count > 0) {
                System.out.println("Guess the correct number. Your guess: ");
                int userInput = numEntered.nextInt();
                if (userInput == NumberGame.randomNumber) {
                    System.out.println("Congrats! You've guessed the correct number" + "\n"
                            + "Generated random number = " + NumberGame.randomNumber + "  Your guess = " + userInput);
                    points=count;
                    break;
                }
                count--;
                if(count!=0){
                    System.out.println("Your guess is incorrect! Try again." + "\n"
                            + "Attempts remaining: " + count);
                } else if(count==0) {
                    System.out.println("Incorrect guess!!" + "\n"
                            + "You've exhausted all 5 attempts. \nAttempts remaing: " + count +
                            "\nGenerated random number = " + NumberGame.randomNumber + "  Your last guess = " + userInput);
                }
            }
            score+=points;
            System.out.println("Points for round " + i + " = " + points);
        }
        System.out.println("Final score = " + score);
    }
}
