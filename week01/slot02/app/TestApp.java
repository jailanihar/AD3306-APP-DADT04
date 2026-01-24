package app;

import game_api.Pirate;

public class TestApp {
    
    public static void main(String[] args) {
        // pirate1 to pirate4 is Local Variables
        Pirate pirate1 = new Pirate("Antah", 5);
        Pirate pirate2 = new Pirate("Berantah", 3);
        Pirate pirate3 = new Pirate("", 4);
        Pirate pirate4 = new Pirate();
        // pirate4.name = "";
        System.out.println(pirate1);
        System.out.println(pirate2);
        System.out.println(pirate3);
        System.out.println(pirate4);
    }

}
