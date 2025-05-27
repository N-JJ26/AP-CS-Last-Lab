package src;

import src.Animal.Consumers.FTundraWolf;
import src.Animal.Consumers.TundraWolf;

public class Runner {
    public static void main(String[] args) {
        TundraWolf wolf = new TundraWolf();
        FTundraWolf folf = new FTundraWolf();

        System.out.println(wolf + "\n" + folf);
    }
}
