package game_api.weapons;

import game_api.Pirate;
import game_api.interfaces.Placeables;

public abstract class Weapon implements Placeables {

    private int damage;

    public Weapon(int damage) {
        setDamage(damage);
    }

    @Override
    public String toString() {
        return "Weapon[" + damage + "dmg]";
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if(damage < 1) {
            damage = 1;
        }
        this.damage = damage;
    }

    public abstract int doDamage(Pirate pirate);

}
