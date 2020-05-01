import java.sql.SQLOutput;
import java.util.Scanner;

public class SwordFight {
    void fight(Player POne, Wait pause){
        Scanner reader = new Scanner(System.in);
        //Create a new enemy
        Enemy One = new Enemy();
        //Set the enemy with a random amount of health
        int min = 50;
        int max = 150;
        int rand = (int) (Math.random() * (max - min + 1) + min);
        One.SetEnemyHP(rand);
        //Ask the user what they want to do
        boolean loop = true;
        pause.Wait2();
        while(loop == true) {
            System.out.println("");
            System.out.println("");
            System.out.println(POne.Name + "! An EnemyKnight has Appeared!");
            System.out.println("What do you want to do!?");
            System.out.println("");
            System.out.println("1.) Fight him!");
            System.out.println("2.) Taunt him and Flee!");
            System.out.println("3.) Run away!");
            System.out.println("4.) Check your Health and armour levels");

            int UserChoice = Integer.parseInt(reader.nextLine());

            switch (UserChoice) {
                case 1:
                    System.out.println("Let the fight begin");
                    System.out.println("");
                    Fight start = new Fight();
                    loop = false;
                    start.FightMethod(POne, pause);
                    break;
                case 2:
                    //NOT DEVELOPED YET
                    System.out.println("You taunt the enemy and run away!");
                    Neutral Runaway = new Neutral();
                    loop = false;
                    break;
                case 3:
                    System.out.println("Running away!!!");
                    Neutral Runaway2 = new Neutral();
                    Runaway2.town(POne, pause);
                    break;
                case 4:
                    System.out.println("Your Health is : " + POne.getHealthPoints());
                    System.out.println("Your Armour is: " + POne.getArmourPoints());
                    break;
            }
        }



    }
}
