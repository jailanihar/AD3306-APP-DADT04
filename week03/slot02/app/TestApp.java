package app;

import game_api.Map;
import game_api.Pirate;
import game_api.weapons.*;

public class TestApp {
    
    public static void main(String[] args) {
        Map map = new Map(5, 5);
        map.addPirate(1, 2, new Pirate("Abu", 4));
        map.addPirate(0, 0, new Pirate("Bakar", 3, 1));
        map.addPirate(4, 3, new Pirate("Curi", 5));
        map.addPirate(2, 4, new Pirate("Daging", 2));
        map.addPirate(1, 0, new Pirate("Emak", 5, 2));
        printArena(map);

        map.movePirateUp(1, 2);
        printArena(map);

        map.movePirateUp(1, 1);
        printArena(map);

        Pirate abu = map.selectPirate(1, 1);
        abu.equipWeapon(new Sword(3));
        printArena(map);

        map.movePirateUp(1, 1);
        printArena(map);

        abu.equipWeapon(new Gun(3, 2));
        printArena(map);

        map.movePirateUp(1, 1);
        printArena(map);

        map.movePirateUp(1, 1);
        printArena(map);

        map.movePirateUp(1, 1);
        printArena(map);
    }

    public static void printArena(Map map) {
        for(int y = 0; y < map.getHeight(); y++) {
            for(int x = 0; x < map.getWidth(); x++) {
                System.out.print(map.selectPirate(x, y) + "\t");
            }
            System.out.println();
        }
        System.out.println("***********");
    }

}
