package game_api;

import game_api.interfaces.Consumables;
import game_api.interfaces.Placeables;
import game_api.weapons.Weapon;

public class Map {

    public static final String DIRECTION_UP = "up";
    public static final String DIRECTION_DOWN = "down";
    public static final String DIRECTION_LEFT = "left";
    public static final String DIRECTION_RIGHT = "right";
    private static final int DEFAULT_SIZE = 5;
    private Placeables[][] arena;

    public Map(int width, int height) {
        if (width < 1) {
            width = DEFAULT_SIZE;
        }
        if (height < 1) {
            height = DEFAULT_SIZE;
        }
        arena = new Placeables[width][height];
    }

    public int getWidth() {
        return arena.length;
    }

    public int getHeight() {
        return arena[0].length;
    }

    public Placeables selectPlaceable(int x, int y) {
        if(checkCoordinate(x, y)) {
            return arena[x][y];
        }
        return null;
    }

    public void addPlaceables(int x, int y, Placeables placeable) {
        if(checkCoordinate(x, y)) {
            arena[x][y] = placeable;
        }
    }

    public Pirate selectPirate(int x, int y) {
        if(checkCoordinate(x, y) && arena[x][y] instanceof Pirate) {
            return (Pirate) arena[x][y];
        }
        return null;
    }

    public void addPirate(int x, int y, Pirate newPirate) {
        if(checkCoordinate(x,y)) {
            arena[x][y] = newPirate;
        }
    }

    // if valid coordinate return true else false
    public boolean checkCoordinate(int x, int y) {
        if(x < 0 || x >= getWidth() || y < 0 || y >= getHeight()) {
            return false;
        } else {
            return true;
        }
    }

    private void movePirate(int currentX, int currentY, int newX, int newY) {
        if(checkCoordinate(currentX, currentY) && checkCoordinate(newX, newY)) {
            Pirate pirate = selectPirate(currentX, currentY);
            Placeables newLocation = selectPlaceable(newX, newY);
            if(pirate != null) {
                if(newLocation != null) {
                    // newLocation is Pirate
                    if(newLocation instanceof Pirate) {
                        Pirate otherPirate = (Pirate) newLocation;
                        // attack the other pirate
                        pirate.attackPirate(otherPirate);
                        if(otherPirate.getHealth() < 1) {
                            occupyLocation(currentX, currentY, newX, newY, pirate);
                        }
                    }
                    // newLocation is Weapon
                    else if(newLocation instanceof Weapon) {
                        pirate.equipWeapon((Weapon) newLocation);
                        occupyLocation(currentX, currentY, newX, newY, pirate);
                    }
                    // newLocation is Consumable
                    else if(newLocation instanceof Consumables) {
                        pirate.heal((Consumables) newLocation);
                        occupyLocation(currentX, currentY, newX, newY, pirate);
                    }
                } else {
                    // move the pirate
                    occupyLocation(currentX, currentY, newX, newY, pirate);
                }
            }
        }
    }

    private void occupyLocation(int currentX, int currentY, int newX, int newY, Pirate pirate) {
        if(pirate != null && checkCoordinate(currentX, currentY) && checkCoordinate(newX, newY)) {
            arena[newX][newY] = pirate;
            arena[currentX][currentY] = null;
        }
    }

    private void movePirate(int currentX, int currentY, String direction) {
        if(direction.equalsIgnoreCase(DIRECTION_UP)) {
            movePirate(currentX, currentY, currentX, currentY - 1);
        } else if(direction.equalsIgnoreCase(DIRECTION_DOWN)) {
            movePirate(currentX, currentY, currentX, currentY + 1);
        } else if(direction.equalsIgnoreCase(DIRECTION_LEFT)) {
            movePirate(currentX, currentY, currentX - 1, currentY);
        } else if(direction.equalsIgnoreCase(DIRECTION_RIGHT)) {
            movePirate(currentX, currentY, currentX + 1, currentY);
        }
    }

    public void movePirateUp(int currentX, int currentY) {
        movePirate(currentX, currentY, DIRECTION_UP);
    }

    public void movePirateDown(int currentX, int currentY) {
        movePirate(currentX, currentY, DIRECTION_DOWN);
    }

    public void movePirateLeft(int currentX, int currentY) {
        movePirate(currentX, currentY, DIRECTION_LEFT);
    }

    public void movePirateRight(int currentX, int currentY) {
        movePirate(currentX, currentY, DIRECTION_RIGHT);
    }

}