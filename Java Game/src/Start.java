import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Start {
    String TutorialChoice;
    int UserChoice;

    void Play() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please Enter your name..");
        Player POne = new Player();
        Wait pause = new Wait();
        POne.Name = reader.nextLine();
        System.out.println("Welcome to Java Quest " + POne.Name);
        System.out.println("Thank you For Trying out My game :)");
        System.out.println("");
        System.out.println("Would you like to view the tutorial?");
        TutorialChoice = reader.nextLine();

        if (TutorialChoice.equals("Yes") | TutorialChoice.equals("yes")) {
            Tutorial Start = new Tutorial();
            Start.Tutorial();
        } else if (TutorialChoice.equals("No") | TutorialChoice.equals("no")) {
            System.out.println("If you say so!");
            System.out.println("Let's get started");


        }

        //Set All Default Values
        POne.setHealthPoints(100);
        POne.setArmourPoints(0);

        int i = 1;
        while (i > 0) {
            System.out.println("");
            System.out.println("To help you on your Quest you take one item I'm offering you");
            System.out.println("");
            System.out.println("1.) A Suit of armour (This will increase your ArmourLevel)");
            System.out.println("2.) A Blessing From The local Princess (Double your Starting Health)");
            System.out.println("Please type the coresponding number of the item you wish to take");
            UserChoice = Integer.parseInt(reader.nextLine());

            // Add 100 armour Points
            if (UserChoice == 1) {
                POne.setArmourPoints(100);
                System.out.println("Your armour is Now At " + POne.getArmourPoints() + "!");
                i = i - 1;
            }
            // Add 100 extra Health
            else if (UserChoice == 2) {
                POne.setHealthPoints(200);
                System.out.println("Your Health is now at " + POne.getHealthPoints() + "!");
                i = i - 1;
            }
            //Re-loop untill a valid item is taken
            else {
                System.out.println("Please Enter a valid number");

            }
        }//End of while
        System.out.println("");
        pause.Wait2();
        RandomEvent E1 = new RandomEvent();
        E1.RandomNumber(POne, pause);


    } //End of void play()
} //End of class Start
