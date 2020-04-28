import java.util.Scanner;

public class Rescue {
    Scanner reader = new Scanner(System.in);
    String userchoice;
    void RescuePrincess(Player POne, Wait pause){
        System.out.println("");
        System.out.println("While On your travels you spot a tower...");
        System.out.println("...It appears to have a Princess trapped inside it!");
        System.out.println("Do you want to rescue her?");
        userchoice = reader.nextLine();
        if(userchoice.equals("Yes") || userchoice.equals("yes")){
            Princess one = new Princess();
            one.StartRescue(POne, pause);
        }else if(userchoice.equals("no") || userchoice.equals("No")){
            pause.Wait2();
            System.out.println("You walk on...");
            pause.Wait1();
            Neutral Town = new Neutral();
            Town.town(POne, pause);
        }
    }

}
