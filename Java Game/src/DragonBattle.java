import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

public class DragonBattle {
    int randomNumber() {
        int max = 100;
        int min = 1;
        int randomNum = (int) (Math.random() * (max - min + 1) + min);
        return randomNum;
    }


    // set up an array of colors
    String[] colors = {"Red", "Green", "Blue", "Purple"};

    //pick a random element from that array
    String getRandom() {
        Random generator = new Random();
        int randomIndex = generator.nextInt(colors.length);
        return colors[randomIndex];
    }

    void DragonAttack(Player POne, Wait pause) {
        Scanner reader = new Scanner(System.in);
        System.out.println("You are trekking through the country side...");
        pause.Wait1();
        System.out.println("Suddenly a giant " + getRandom() + " Dragon appears!!");
        pause.Wait1();
        System.out.println("What do you want to do?");
        System.out.println("");
        System.out.println("1.) Fight the dragon!");
        System.out.println("2.) Run away!!");
        System.out.println("3.) Accept your fate and allow the dragon to finish you");
        int UserChoice = Integer.parseInt(reader.nextLine());

        switch (UserChoice) {
            case 1:
                BattleDragon(POne, pause);
                break;
            case 2:
                System.out.println("You begin to run");
                // get new random number
                int rand = randomNumber();
                if (rand >= 1 && rand <= 50) { // if less than or equal to 50 then the escape is a success
                    pause.Wait1();
                    System.out.println("Luckily you escape sucessfully!");
                    pause.Wait1();
                    Neutral DragonEscape = new Neutral();
                    DragonEscape.town(POne, pause);


                } else if (rand > 50 && rand <= 100) {
                    pause.Wait1();
                    System.out.println("The dragon spots you and flames shoot out of it's gaping mouth");
                    pause.Wait1();
                    System.out.println("They are aimed at you!");
                    POne.setArmourPoints(0);
                    POne.setHealthPoints(0);
                    POne.checkHealth();
                } // end else if
                break; // end of case 2

            case 3:
                pause.Wait1();
                System.out.println("You are aware of how powerful dragons are");
                pause.Wait1();
                System.out.println("You Kneel as the dragon spots you");
                pause.Wait1();
                System.out.println("Your life has come to an end....");
                POne.setHealthPoints(0);
                POne.setArmourPoints(0);
                POne.checkHealth();
        } // end of switch
    } // method


    void BattleDragon(Player POne, Wait pause) {
        System.out.println("You scream a battle cry too gain the dragons attention!");
        pause.Wait1();
        System.out.println("The dragon glares at you menacingly...");
        int dieOrLive = randomNumber();
        if (dieOrLive <= 50) {
            System.out.println("you charge towards the dragon and jab your sword into the dragons scaley feet");
            pause.Wait1();
            System.out.println("Thick blue blood shoots out from it's foot");
            int flyorstay = randomNumber();
            if (flyorstay >= 50) {
                pause.Wait1();
                System.out.println("The Dragon Screams and flies away");
                pause.Wait1();
                System.out.println("You are safe... for now....");
                Neutral Success = new Neutral();
                Success.town(POne, pause);
            } else {
                pause.Wait1();
                System.out.println("The Dragon Screams and raises it's foot");
                pause.Wait1();
                System.out.println("It slams down over you..");
                pause.Wait1();
                POne.setArmourPoints(0);
                POne.setHealthPoints(0);
                POne.checkHealth();
            }

        } else if (dieOrLive >= 50) {
            pause.Wait1();
            System.out.println("Flames fly out of the dragons mouth..");
            System.out.println("Your life has come to an end....");
            POne.setHealthPoints(0);
            POne.setArmourPoints(0);
            POne.checkHealth();
        }


    }
} // class
