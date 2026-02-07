package game_api.weapons;

import game_api.Pirate;

public class Weapon {

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

    public int doDamage(Pirate pirate) {
        if(pirate != null) {
            int newDamage = damage - pirate.getDefence();
            return newDamage;
        }
        return -1;
    }

}
