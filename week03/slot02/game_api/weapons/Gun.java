// Gun
// Is a type of Weapon
// do damage, check if it has ammo
// If it has ammo do the damage by damage - defence
// If it does not have ammo, return -1

package game_api.weapons;

import game_api.Pirate;

public class Gun extends Weapon {

    private int ammo;

    public Gun(int damage, int ammo) {
        super(damage);
        if(ammo < 0) {
            ammo = 1;
        }
        this.ammo = ammo;
    }

    @Override
    public String toString() {
        return "Gun[" + getDamage() + "dmg, " + ammo + "a]";
    }

    @Override
    public int doDamage(Pirate pirate) {
        if(pirate != null && ammo > 0) {
            ammo--;
            return super.doDamage(pirate);
        }
        return -1;
    }

}