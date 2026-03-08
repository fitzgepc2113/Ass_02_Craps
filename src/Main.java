import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Random gen = new Random();

        Scanner in = new Scanner(System.in);

        String playAgain = "";
        boolean done1 = false;
        boolean done2 = false;
        boolean answer = false;


        do {
            int die1 = 0;
            int die2 = 1;
            int dieRoll = die1 + die2;
            int thePoint= 0;

            die1 = gen.nextInt(6) + 1;
            die2 = gen.nextInt(6) + 1;
            dieRoll = die1 + die2;


            System.out.println("Roll: " + die1 + " + " + die2 + " = " + dieRoll );

            if (dieRoll == 2 || dieRoll == 3 || die2 == 12){

                System.out.println("Craps! You Lose!");

            } else if (dieRoll == 7 || dieRoll == 11) {
                System.out.println("Natural! You Win!");

            } else {

                thePoint = dieRoll;
                System.out.println("The point is " + thePoint);


                do {
                    die1 = gen.nextInt(6) + 1;
                    die2 = gen.nextInt(6) + 1;
                    dieRoll = die1 + die2;
                    System.out.println("Trying for the Point! The Point is: " + thePoint);
                    System.out.println("Roll: " + die1 + " + " + die2 + " = " + dieRoll );

                    if (dieRoll == 7){

                        System.out.println("You rolled a 7. You Lose!");
                        done2 = true;

                    } else if (dieRoll == thePoint) {

                        System.out.println("You made the point! You Win!");
                        done2 = true;
                    }
                    else {
                        System.out.println("You did not make the point! Roll Again!");
                        done2 = false;
                    }

                }
                while (!done2);

            }

            do {
                System.out.println("Would you like to play again[Y/N]?");
                playAgain = in.nextLine();
                if (playAgain.equalsIgnoreCase("Y"))
                {
                    answer = true;
                    done1 = false;
                }
                else if (playAgain.equalsIgnoreCase("N"))
                {
                    answer = true;
                    done1 = true;
                }
                else
                {
                    System.out.println("Inavlid answer! Please choose [Y/N].");
                }

            } while (!answer);


        }
        while (!done1) ;


    }
}