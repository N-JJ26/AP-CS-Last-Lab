package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.Animal.Animal;
import src.Animal.Consumers.*;
import src.Plants.Plant;
import src.Plants.Producers.ArcticDaisy;
import src.Plants.Producers.ArcticWillow;
import src.Plants.Producers.CaribouMoss;

public class Runner {
    private static final int NUM_PLANTS = 3;
    private static final int NUM_ANIMALS = 5;

    private static Plant[] plants = new Plant[NUM_PLANTS];
    private static Animal[][] animals = new Animal[NUM_ANIMALS][];

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        plants[0] = new ArcticDaisy();
        plants[1] = new ArcticWillow();
        plants[2] = new CaribouMoss();

        System.out.println("Animals (number of adults):\nArctic Fox = ");
        animals[0] = Math.random() < 0.5 ? new ArcticFox[5] : new FArcticFox[5];
    }

    private static Animal[] shuffle(Animal[] animals)
    {
        for(int i = 0; i < Runner.animals.length; i++) {
            int index = (int)(Math.random() * animals.length);
            
            Animal temp = animals[i];
            animals[i] = animals[index];
            animals[index] = temp;
        }

        return animals;
    }
}
