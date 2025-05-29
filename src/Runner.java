package src;

import java.util.ArrayList;
import java.util.Scanner;

import src.Animal.*;
import src.Animal.Consumers.*;
import src.Plants.Plant;
import src.Plants.Producers.*;
/**
 * Runner
 * 
 * @author Nate Johnson, Austin Benedicto, Avi D.
 * @version 5/27/2025
 */
public class Runner
{
    private static final int NUM_PLANTS = 3;
    private static final int NUM_ANIMALS = 5;

    private static final int DAISY_INDEX = 0;
    private static final int WILLOW_INDEX = 1;
    private static final int MOSS_INDEX = 2;

    private static final int FOX_INDEX = 0;
    private static final int HARE_INDEX = 1;
    private static final int CARIBOU_INDEX = 2;
    private static final int POLAR_BEAR_INDEX = 3;
    private static final int WOLF_INDEX = 4;

    private static Plant[] plants = new Plant[NUM_PLANTS];
    private static Animal[][] animals = new Animal[NUM_ANIMALS][];

    private static Scanner in = new Scanner(System.in);

    /**
     * Main method to start the simulation.
     * It initializes the populations of plants and animals, and begins the simulation sequence.
     */
    public static void main(String[] args)
    {
        beginningSequence();
    }

    private static void beginningSequence()
    {
        System.out.println("Welcome to Caribou Run Ranch\n" +
                            "Please enter the amount of each population:\n");

        System.out.print("Plants (acres):\nArctic Daisies = ");
        plants[DAISY_INDEX] = new ArcticDaisy(in.nextInt());

        System.out.print("Arctic Willow = ");
        plants[WILLOW_INDEX] = new ArcticWillow(in.nextInt());

        System.out.print("Caribou Moss = ");
        plants[MOSS_INDEX] = new CaribouMoss(in.nextInt());

        System.out.print("\nAnimals (initial number of adults):\nArctic Foxes = ");
        animals[FOX_INDEX] = new ArcticFox[in.nextInt()];

        System.out.print("Arctic Hares = ");
        animals[HARE_INDEX] = new ArcticHare[in.nextInt()];

        System.out.print("Caribous = ");
        animals[CARIBOU_INDEX] = new Caribou[in.nextInt()];

        System.out.print("Polar Bears = ");
        animals[POLAR_BEAR_INDEX] = new PolarBear[in.nextInt()];

        System.out.print("Tundra Wolves = ");
        animals[WOLF_INDEX] = new TundraWolf[in.nextInt()];
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

    private static Animal[] shufflePack(Animal[] animals, int packSize)
    {
        for(int i = 0; i < Runner.animals.length; i++) {
            int index = (int)(Math.random() * animals.length / packSize);
            
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
