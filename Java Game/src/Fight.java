import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Fight {
    void FightMethod(Player POne) {
        Scanner reader = new Scanner(System.in);
        int x = 5;
        // Setup enemy knight
        Enemy Jeff = new Enemy();
        Jeff.SetEnemyHP(100);

        while (Jeff.GetEnemyHP() > 0 && POne.getHealthPoints() > 0) {
            //ENEMYS CHOICE
            //Generate a random number from 1 to 100
            int min = 1;
            int max = 100;
            int rand = (int) (Math.random() * (max - min + 1) + min);
            // use that random number to decide what the enemy will do
            if (rand > 0 && rand < 5) { //5% chance
                System.out.println("The Enemy Knight cut off your head with one clean stroke!");
                System.out.println("GAME OVER!");
                POne.setHealthPoints(0);
                POne.setArmourPoints(0);
                System.exit(0); // quits the program
            }
            // Enemy misses
            else if (rand > 5 && rand < 25) { //35% chance
                System.out.println("");
                System.out.println("The Enemy missed!");
            }
            // enemy hits you
            else if (rand > 25 && rand <= 100) { //60% chance
                System.out.println("You were hit! You have lost 15 health and/or armour!");
                int damage = 15;
                int restOfDamage;
                // if they have armour take the armour away first
                if (POne.getArmourPoints() > 0) {
                    while (POne.getArmourPoints() > 0 && damage > 0) {
                        POne.setArmourPoints(POne.getArmourPoints() - 1);
                        damage = damage - 1;
                    }
                    // If all the armour is gone take the remaining from there health points
                    restOfDamage = damage;
                    POne.setHealthPoints(POne.getHealthPoints() - restOfDamage);
                }
                // if they only have health points take it from there
                else {
                    POne.setHealthPoints(POne.getHealthPoints() - damage);
                }

            } // else if
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            //PLAYERS CHOICE
            System.out.println("");
            System.out.println(POne.Name + " What do you want to do?");
            System.out.println("1.) Attack him");
            System.out.println("2.) Check Your Health and Armour values ");
            int which = Integer.parseInt(reader.nextLine());
            System.out.println(" ");

            if (which == 2) {
                System.out.println("Your Health points is : " + POne.getHealthPoints());
                System.out.println("Your Armour points is : " + POne.getArmourPoints());
            } else if (which == 1) {
                //Generate a random number from 1 to 100
                int min2 = 1;
                int max2 = 100;
                int rand2 = (int) (Math.random() * (max2 - min2 + 1) + min);
                // use that random number to decide what the enemy will do
                if (rand2 > 0 && rand2 < 5) { //5% chance
                    System.out.println("You Cut off the enemys Head");
                    System.out.println("You Win this fight!");
                    Jeff.SetEnemyHP(0);

                }
                // player misses
                else if (rand2 > 5 && rand2 < 25) { //35% chance
                    System.out.println("You missed!");
                }
                // Player hits
                else if (rand2 > 25 && rand2 <= 100) { //60% chance
                    Jeff.SetEnemyHP(Jeff.GetEnemyHP() - 15);
                    System.out.println("Good Hit!");


                }
            }// else if

            if(Jeff.GetEnemyHP() == 0){
                System.out.println("You Won!");
            }

            //sleep for 3 seconds
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }// while
        System.out.println("NOTHING IS DEVELOPED BEYOND THIS POINT");

    } //method

}//class
