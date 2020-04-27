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
}
