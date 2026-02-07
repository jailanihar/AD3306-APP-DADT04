package game_api;

public class Map {

    public static final String DIRECTION_UP = "up";
    public static final String DIRECTION_DOWN = "down";
    public static final String DIRECTION_LEFT = "left";
    public static final String DIRECTION_RIGHT = "right";
    private static final int DEFAULT_SIZE = 5;
    // private Pirate[][] arena = new Pirate[5][5];
    private Pirate[][] arena;
    // Pirate[width or x][height or y]

    public Map(int width, int height) {
        if (width < 1) {
            width = DEFAULT_SIZE;
        }
        if (height < 1) {
            height = DEFAULT_SIZE;
        }
        arena = new Pirate[width][height];
    }

    public int getWidth() {
        return arena.length;
    }

    public int getHeight() {
        return arena[0].length;
    }

    public Pirate selectPirate(int x, int y) {
        if(checkCoordinate(x, y)) {
            return arena[x][y];
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
            Pirate newLocation = selectPirate(newX, newY);
            if(pirate != null) {
                if(newLocation != null) {
                    // attack the other pirate
                    pirate.attackPirate(newLocation);
                    if(newLocation.getHealth() < 1) {
                        arena[newX][newY] = pirate;
                        arena[currentX][currentY] = null;
                    }
                } else {
                    // move the pirate
                    arena[newX][newY] = pirate;
                    arena[currentX][currentY] = null;
                }
            }
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