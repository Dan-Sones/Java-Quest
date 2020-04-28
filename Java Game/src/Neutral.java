import jdk.swing.interop.SwingInterOpUtils;

import java.sql.SQLOutput;

public class Neutral {
    int FriendOrFoe;
    int armourOrHealth;
    int count = 100;
    int randomChoice;
    void town(Player POne) {
        // Tell Player They have entered a nearby town
        System.out.println("");
        System.out.println("You have entered a town");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        // Generate a random number out of either one or two
        int min = 1;
        int max = 2;
        int random = (int) (Math.random() * (max - min + 1) + min);

        //If the Number is one then :
        switch (random) {
            case 1:
                System.out.println("Thank Goodness this Town is an ally");
                armourOrHealth = (int) (Math.random() * (max - min + 1) + min); // Generate A random Number

                if (armourOrHealth == 1 && POne.getHealthPoints() < 200) { //if one is generated and they have less than 200 HP
                    System.out.println("They Offer you Medical attention");
                    while (count > 0 && POne.getHealthPoints() <= 200) { //Give 100 HP
                        POne.setHealthPoints(POne.getHealthPoints() + 1);
                        count = count - 1;
                    }
                    System.out.println("");
                    System.out.println("You Have been given 100 Health Points!");
                    System.out.println("You now have " + POne.getHealthPoints() + " Health Points!");
                    System.out.println("");

                } else if (armourOrHealth == 2 && POne.getArmourPoints() < 100) {
                    System.out.println("They Offer You a new suit of armour");
                    while (count > 0 && POne.getArmourPoints() <= 100) {
                        POne.setArmourPoints(POne.getArmourPoints() + 1);
                        count = count - 1;
                    }
                    System.out.println("");
                    System.out.println("Your armour is now full at " + POne.getArmourPoints() + " Armour Points!");
                }
                break; // end of case 1
            case 2:
                System.out.println("Oh now It's an enemy town!!");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("You start to Run away");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                random = (int) (Math.random() * (max - min + 1) + min); // Generates a random number between 1 and 2
                switch (random) {
                    case 1:
                        System.out.println("You escape with no injurys!");
                        break;
                    case 2:
                        count = 10;
                        System.out.println("An arrow Hits you during your escape!");
                        System.out.println("You Have Lost 10 health!");
                        if (POne.getArmourPoints() < 0) {
                            while (POne.getArmourPoints() < 0) {
                                count = count - 1;
                                POne.setArmourPoints(POne.getArmourPoints() - 1);
                            }
                            if (count > 0) {
                                while (count > 0) {
                                    POne.setHealthPoints(POne.getHealthPoints() - 1);
                                    POne.checkHealth();
                                }
                            }
                        } //main if
                        break;
                }// end of switch


                System.out.println("");
                System.out.println("You Contnue Your Adventure...");


                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

                RandomEvent E2 = new RandomEvent();
                E2.RandomNumber(POne);
        }


    }
}
