package game_api;

public class Pirate {
    
    // Constant Class Variables
    private final static String DEFAULT_NAME_PREFIX = "Pirate";
    private final static int DEFAULT_HEALTH = 5;
    // Class Variables
    private static int totalDefaultPirates = 1;
    // Instance Variables
    private String name;
    private int health;

    public Pirate() {
        this("", DEFAULT_HEALTH);
        // name = DEFAULT_NAME_PREFIX + totalDefaultPirates;
        // totalDefaultPirates++;
        // health = DEFAULT_HEALTH;
    }

    // Constructor        // Parameter Variables
    public Pirate(String pName, int pHealth) {
        if(pName == null || pName.equals("")) {
            pName = DEFAULT_NAME_PREFIX + totalDefaultPirates;
            totalDefaultPirates++;
        }
        name = pName;
        if(pHealth < 1) {
            pHealth = DEFAULT_HEALTH;
        }
        health = pHealth;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + health + "]";
    }

}