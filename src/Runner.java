package src;

import java.lang.reflect.Array;
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

    private static int months = 1;
    private static int years = 1;

    private static Scanner in = new Scanner(System.in);

    /**
     * Main method to start the simulation.
     * It initializes the populations of plants and animals, and begins the simulation sequence.
     */
    public static void main(String[] args)
    {
        beginningSequence();
        shuffleAll();
        runSimulation();
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

        System.out.print("Tundra Wolves (multiple of 6) = ");
        animals[WOLF_INDEX] = new TundraWolf[in.nextInt()];

        System.out.println();

        information();
    }

    private static void runSimulation() {

    }

    private static void information() {
        System.out.printf("Daisies: %d percent; Willows: %d percent; Moss %d percent\n",
                        plants[DAISY_INDEX].getPercentRemaining(),
                        plants[WILLOW_INDEX].getPercentRemaining(),
                        plants[MOSS_INDEX].getPercentRemaining());
        System.out.printf("Foxes %d; Hares %d; Caribous %d; Polar Bears %d; Wolves %d\n",
                        animals[FOX_INDEX].length,
                        animals[HARE_INDEX].length,
                        animals[CARIBOU_INDEX].length,
                        animals[POLAR_BEAR_INDEX].length,
                        animals[WOLF_INDEX].length);
    }

    private static Animal[] shuffle(Animal[] animals)
    {
        for(int i = 0; i < animals.length; i++)
        {
            int index = (int)(Math.random() * animals.length);

            Animal temp = animals[i];
            animals[i] = animals[index];
            animals[index] = temp;
        }

        return animals;
    }

    private static Animal[] shufflePack(Animal[] animals, int packSize)
    {
        for(int i = 0; i < animals.length; i += packSize)
        {
            for (int j = i; j < packSize; j++) {
                int index = (int)(Math.random() * animals.length / packSize);

                Animal temp = animals[i];
                animals[i] = animals[index];
                animals[index] = temp;
            }
        }

        return animals;
    }

    private static void shuffleAll() {
        for(int i = 0; i < animals.length - 1; i++) {
            shuffle(animals[i]);
        }
        shufflePack(animals[WOLF_INDEX], TundraWolf.PACK_SIZE);
    }

    private static Animal[] removeDead(Animal[] deadAnimals)
    {
        ArrayList<Animal> a = new ArrayList<Animal>();

        for(Animal animal : deadAnimals)
            a.add(animal);

        for(int i = deadAnimals.length - 1; i >= 0; i--){
            if(!a.get(i).isAlive())
                a.remove(i);
        }

        deadAnimals = (Animal[])a.toArray();

        return deadAnimals;
    }

    private static Animal[] allBirths( Animal[] birthingAnimals )
    {
        ArrayList<Animal> females = new ArrayList<Animal>();
        ArrayList<Animal> allAnimals = new ArrayList<Animal>();


        for (int i = 0; i < birthingAnimals.length; i++) {
            Animal animal = birthingAnimals[i];
            allAnimals.add(animal);
            if (animal instanceof Female) {
                females.add(animal);
            }
        }

    
        for (int i = 0; i < females.size(); i++) {
            Female f = (Female)females.get(i);
            Animal[] babies = f.giveBirth();
            if (babies != null) {
                for( int j = 0; j < babies.length; j++)
                    allAnimals.add(babies[i]);
            }
        }

    
        birthingAnimals = (Animal[])allAnimals.toArray();

        return birthingAnimals;
    }

    private static void allReproduce(Animal[] femaleAnimals)
    {
        boolean[] maleUsed = new boolean[animals.length];

        for (int i = 0; i < femaleAnimals.length; i++)
        {
            if (femaleAnimals[i] instanceof Female)
            {
                Female female = (Female) femaleAnimals[i];
                for (int j = 0; j < animals.length; j++)
                {
                    if (!maleUsed[j]
                        && femaleAnimals[j] != null
                        && !(femaleAnimals[j] instanceof Female)
    )
                    {
                        // Found an unused male of the same species
                        female.reproduceWith(femaleAnimals[j]);
                        maleUsed[j] = true;
                        break; // Move to next female
                    }
                }
            }
        }
    }

    private static void eat() {

    }
}

