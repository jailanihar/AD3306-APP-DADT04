package game_api;

import game_api.weapons.Weapon;

public class Pirate {
    
    // Constant Class Variables
    private final static String DEFAULT_NAME_PREFIX = "Pirate";
    private final static int DEFAULT_HEALTH = 5;
    // Class Variables
    private static int totalDefaultPirates = 1;
    // Instance Variables
    private String name;
    private int health;
    private int defence;
    private Weapon weapon;

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

    public Pirate(String name, int health, int defence) {
        this(name, health);
        if(defence < 0) {
            defence = 0;
        }
        this.defence = defence;
    }

    @Override
    public String toString() {
        // return "[" + name + ", " + health + "]";
        return "[" + name + ", " + health + "h, "
            + defence + "d, " + weapon + "]";
    }

    public void attackPirate(Pirate otherPirate) {
        if(otherPirate == null || otherPirate == this) {
            return;
        }
        if(weapon != null) {
            int damage = weapon.doDamage(otherPirate);
            // otherPirate.health -= damage;
            if(damage > 0) {
                otherPirate.health = otherPirate.health - damage;
            }
        } else {
            if(otherPirate.defence < 1) {
                otherPirate.health--;
            }
        }
    }

    public int getHealth() {
        return health;
    }

    public void equipWeapon(Weapon weapon) {
        if(weapon != null) {
            this.weapon = weapon;
        }
    }

    public void unEquipWeapon() {
        weapon = null;
    }

    public int getDefence() {
        return defence;
    }

}