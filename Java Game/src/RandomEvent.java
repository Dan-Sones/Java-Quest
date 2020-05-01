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
    void RandomNumber(Player POne, Wait pause) {

        int min = 1;
        int max = 3;
        int rand = (int) (Math.random() * (max - min + 1) + min);
        setRandom(rand);

        if (rand == 1) {
            // rescue
            Rescue rescue = new Rescue();
            rescue.RescuePrincess(POne, pause);
        } else if (rand == 2) {
            countFights = countFights + 1;
            SwordFight sword = new SwordFight();
            sword.fight(POne, pause);
        } else if (rand == 3) {
            DragonBattle Dragon = new DragonBattle();
            Dragon.DragonAttack(POne, pause);

        }

    }

}
