package game_api;

import game_api.interfaces.Consumables;
import game_api.interfaces.Placeables;

public class Chicken implements Placeables, Consumables {

    private boolean isRaw;

    public Chicken(boolean isRaw) {
        this.isRaw = isRaw;
    }

    @Override
    public String toString() {
        return "Chicken[raw?" + isRaw + "]";
    }

    @Override
    public int doHealing(Pirate pirate) {
        if(pirate != null) {
            if(isRaw) {
                int newHealth = pirate.getHealth() - 1;
                return newHealth;
            } else {
                int newHealth = pirate.getHealth() + 2;
                return newHealth;
            }
        }
        return -1;
    }
    
}
