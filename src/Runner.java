package src;

import java.util.ArrayList;

import src.Animal.Animal;
import src.Animal.Consumers.*;
import src.Plants.Plant;
import src.Plants.Producers.ArcticDaisy;
import src.Plants.Producers.ArcticWillow;
import src.Plants.Producers.CaribouMoss;

public class Runner {
    private static final int NUM_PLANTS = 3;
    private static final int NUM_ANIMALS = 10;

    private static Plant[] plants = new Plant[NUM_PLANTS];
    private static ArrayList<Animal>[] animals = new ArrayList[NUM_ANIMALS];

    public static void main(String[] args) {
        plants[0] = new ArcticDaisy();
        plants[1] = new ArcticWillow();
        plants[2] = new CaribouMoss();
    }
}
