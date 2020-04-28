import java.util.Scanner;
public class Player {
    String Name;
    private int HealthPoints;
    private int ArmourPoints;
    private String Inventory[];

    // Health Points
    public int getHealthPoints() {
        return HealthPoints;
    }

    public void setHealthPoints(int HP) {
        HealthPoints = HP;
    }

    //Armour Points
    public int getArmourPoints() {
        return ArmourPoints;
    }

    public void setArmourPoints(int AP) {
        ArmourPoints = AP;
    }

    //Inventory
    public String[] getInventory() {
        return Inventory;
    }

    public void setInventory(String[] Inven) {
        Inventory = Inven;
    }
    // Check Health method
    void checkHealth(){
        if (getHealthPoints() == 0){
            System.out.println("You Have Died!");
            System.out.println("The game will quit in 5 seconds");
            try
            {
                Thread.sleep(5000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            System.exit(1);
        }
    }
}

