package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.Animal.*;
import src.Animal.Consumers.*;
import src.Plants.Plant;
import src.Plants.Producers.*;

public class Runner {
    private static final int NUM_PLANTS = 3;
    private static final int NUM_ANIMALS = 5;

    private static final int DAISY = 0;
    private static final int WILLOW = 1;
    private static final int MOSS = 2;

    private static final int FOX = 0;
    private static final int HARE = 1;
    private static final int CARIBOU = 2;
    private static final int POLAR_BEAR = 3;
    private static final int WOLF = 4;

    private static Plant[] plants = new Plant[NUM_PLANTS];
    private static Animal[][] animals = new Animal[NUM_ANIMALS][];

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        beginningSequence();
    }

    private static void beginningSequence()
    {
        System.out.print("Plants (acres):\nArctic Daisies = ");
        plants[DAISY] = new ArcticDaisy(in.nextInt());
        in.next();

        System.out.print("Arctic Willow = ");
        plants[WILLOW] = new ArcticWillow(in.nextInt());
        in.next();

        System.out.print("Caribou Moss = ");
        plants[MOSS] = new CaribouMoss(in.nextInt());
        in.next();

        System.out.print("Animals (initial number of adults):\nArctic Foxes = ");
        animals[FOX] = new ArcticFox[in.nextInt()];
        in.next();

        System.out.print("Arctic Hares = ");
        animals[HARE] = new ArcticHare[in.nextInt()];
        in.next();

        System.out.print("Caribous = ");
        animals[CARIBOU] = new Caribou[in.nextInt()];
        in.next();

        System.out.print("Polar Bears = ");
        animals[POLAR_BEAR] = new PolarBear[in.nextInt()];
        in.next();

        System.out.print("Tundra Wolves = ");
        animals[WOLF] = new TundraWolf[in.nextInt()];
        in.next();
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

    private static Animal[] removeDead(Animal[] animals)
    {
        ArrayList<Animal> a = new ArrayList<>();

        for(Animal animal : animals)
            a.add(animal);

        for(int i = 0; i < animals.length; i++)
            if(!a.get(i).isAlive())
                a.remove(i);

        return animals;
    }
}
