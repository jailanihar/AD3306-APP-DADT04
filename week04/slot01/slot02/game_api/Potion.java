package game_api;

import game_api.interfaces.Consumables;
import game_api.interfaces.Placeables;

public class Potion implements Consumables, Placeables {
 
    private int heal;

    public Potion(int heal) {
        setHeal(heal);
    }

    @Override
    public String toString() {
        return "Potion[" + heal + "h]";
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        if(heal < 1) {
            heal = 1;
        }
        this.heal = heal;
    }

    @Override
    public int doHealing(Pirate pirate) {
        if(pirate != null) {
            int newHealth = pirate.getHealth() + heal;
            return newHealth;
        }
        return -1;
    }
    
}