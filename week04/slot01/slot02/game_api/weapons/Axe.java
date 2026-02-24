package game_api.weapons;

import game_api.Pirate;

public class Axe extends Weapon {

    public Axe(int damage) {
        super(damage);
    }

    @Override
    public String toString() {
        return "Axe[" + getDamage() + "dmg]";
    }

    @Override
    public int doDamage(Pirate pirate) {
        if(pirate != null) {
            return getDamage();
        }
        return -1;
    }

}