import java.util.Random;

public class RandomEvent {
    int countFights;

    private int Random;

    public int getRandom() {
        return Random;
    }

    public void setRandom(int r) {
        Random = r;
    }


    //generate a random Number
    void RandomNumber(Player POne){
        int min = 2;
        int max = 2;
        int rand = (int) (Math.random() * (max - min + 1) + min);
        setRandom(rand);

        if (getRandom() == 1){
            //Start Dragon Battle
            System.out.println("Dragon");
        }
        else if(getRandom() == 2){
            countFights = countFights + 1;
            SwordFight sword = new SwordFight();
            sword.fight(POne);




        }
        else if(getRandom() == 3){
            //Start Rescue
            System.out.println("rescue");
        }

    }

}
