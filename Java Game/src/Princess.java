import java.sql.SQLOutput;
import java.util.Scanner;
public class Princess {
    Scanner reader = new Scanner(System.in);
    int min = 1;
    int max = 100;
    int rand = (int) (Math.random() * (max - min + 1) + min);
    int rand1;
    int rand2;
    int answer;
    String UserChoice;
    int OutOrIn;
    void StartRescue(Player POne, Wait pause){
        System.out.println("");
        System.out.println("As You Walk closer and closer to the tower you notice that there is a moat of lava surrounding the tower!");
        System.out.println("Do you try and jump over it?");
        UserChoice = reader.nextLine();
        if (UserChoice.equals("Yes") || UserChoice.equals("yes")){
            System.out.println("You Run Towards the lava and jump at the last moment!");
            System.out.println("");
            //Dies - 25% Chance
            if(rand > 0 && rand < 25){
                System.out.println("Oh no You fell in!!!");
                POne.setHealthPoints(0);
                POne.setArmourPoints(0);
                POne.checkHealth();
            }
            //Alive - 75% chance
            else if(rand > 25 && rand <= 100){
                System.out.println("");
                System.out.println("You made it across!");
                System.out.println("You Run over to the stairs.. ");
                pause.Wait1();
                System.out.println(".. and begin to run up ");
                pause.Wait1();
                System.out.println("As you reach the top the door is locked");
                System.out.println("To enter you must answer three questions");
                System.out.println("");
                //make random numbers for questions and ask questions
                int counter = 1;
                while (counter <= 3){
                    max = 12;
                    min = 1;
                    rand1 = (int) (Math.random() * (max - min + 1) + min);
                    rand2 = (int) (Math.random() * (max - min + 1) + min);
                    System.out.println(counter + ".) " + rand1 + "x" + rand2 + " ?");
                    System.out.println("Type your answer");
                    answer = Integer.parseInt(reader.nextLine());
                    if(answer == rand1 * rand2 ){
                        System.out.println("Correct!");
                        counter = counter + 1;
                    }
                    else {
                        System.out.println("Incorrect!");
                    }
                }// end of while
                System.out.println("You unlock the door...");
                pause.Wait1();
                System.out.println("The Princess Screams in shock");
                System.out.println("'I'm here to save you don't worry!'");
                System.out.println("To escape from the tower do you either :");
                System.out.println("");
                System.out.println("1.) Jump from the tower using the bedsheet as a parachute");
                System.out.println("2.) Follow the stairs to the lava moat");
                OutOrIn = Integer.parseInt(reader.nextLine());

                switch (OutOrIn){
                    case 1:
                        System.out.println("You jump while the Princess clutches onto you...");
                        pause.Wait2();
                        System.out.println("It works! You safely glide to the ground!");
                        System.out.println("'Thank you for saving my life' Exclaims the princess");
                        pause.Wait1();
                        System.out.println("You each part your seperate ways...");
                        pause.Wait2();
                        Neutral town = new Neutral();
                        town.town(POne, pause);
                        break;

                    case 2:
                        System.out.println("You start to walk down the stairs..");
                        pause.Wait1();
                        System.out.println("Half way down you feel something press into the step underneath your boot");
                        pause.Wait1();
                        System.out.println("Oh no it's a pressure plate");
                        Art Bang = new Art();
                        Bang.bang(); // ascii art
                        POne.setArmourPoints(0);
                        POne.setHealthPoints(0);
                        POne.checkHealth();


                }






            }// end of survived if


        } else if(UserChoice.equals("no") || UserChoice.equals("No")){
            pause.Wait1();
            System.out.println("That's the only way up!");
            System.out.println("You abandon the rescue and head to the nearest town");
            Neutral Town = new Neutral();
            Town.town(POne, pause);
        }
    }
}
