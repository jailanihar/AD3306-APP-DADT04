package game_api.weapons;

import game_api.Pirate;
import game_api.interfaces.Consumables;

public class Drumstick extends Weapon implements Consumables {

    public Drumstick(int damage) {
        super(damage);
    }

    @Override
    public int doDamage(Pirate pirate) {
        if(pirate != null && pirate.getDefence() > 0) {
            int newDamage = getDamage() * 2;
            return newDamage;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Drumstick [" + getDamage() + "dmg]";
    }

    @Override
    public int doHealing(Pirate pirate) {
        if(pirate != null) {
            int newHealth = getDamage();
            return newHealth;
        }
        return -1;
    }

}