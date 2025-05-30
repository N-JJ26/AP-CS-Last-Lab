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

    private static Scanner in = new Scanner(System.in);

    /**
     * Main method to start the simulation.
     * It initializes the populations of plants and animals, and begins the simulation sequence.
     */
    public static void main(String[] args)
    {
        beginningSequence();

        for(int timesRan = 0; timesRan < 730; timesRan++)
        {
            for(int i = 0; i < plants.length; i++)
            {
                if(plants[i] != null)
                    plants[i].grow();
            }

            for(int i = 0; i < animals.length; i++)
            {
                if(animals[i] != null)
                {
                    for(int j = 0; j < animals[i].length; j++)
                    {
                        if(animals[i][j] != null)
                        {
                            animals[i][j].aging();
                        }
                    }
                }
            }

            for(int i = 0; i < animals.length; i++)
            animals[i] = shuffle(animals[i]);

            animals[WOLF_INDEX] = shufflePack(animals[WOLF_INDEX], TundraWolf.PACK_SIZE);

            for(int i = 0; i < animals.length; i++)
                animals[i] = removeDead(animals[i]);

        }
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
        for(int i = 0; i < Runner.animals.length; i++)
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

    private static Animal[] removeDead(Animal[] animals)
    {
        ArrayList<Animal> a = new ArrayList<Animal>();

        for(Animal animal : animals)
            a.add(animal);

        for(int i = 0; i < animals.length; i++){
            if(!a.get(i).isAlive())
                a.remove(i);
        }

        animals = (Animal[])a.toArray();

        return animals;
    }

    private static Animal[] allBirths( Animal[] animals )
    {
        ArrayList<Animal> females = new ArrayList<Animal>();
        ArrayList<Animal> allAnimals = new ArrayList<Animal>();

    
        for (int i = 0; i < animals.length; i++) {
            Animal animal = animals[i];
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

    
        animals = (Animal[])allAnimals.toArray();

        return animals;
    }

    private static void allReproduce(Animal[] animals)
    {
        boolean[] maleUsed = new boolean[animals.length];

        for (int i = 0; i < animals.length; i++)
        {
            if (animals[i] instanceof Female)
            {
                Female female = (Female) animals[i];
                for (int j = 0; j < animals.length; j++)
                {
                    if (!maleUsed[j]
                        && animals[j] != null
                        && !(animals[j] instanceof Female)
    )
                    {
                        // Found an unused male of the same species
                        female.reproduceWith(animals[j]);
                        maleUsed[j] = true;
                        break; // Move to next female
                    }
                }
            }
        }
    }

    private static void allEat(Animal[] animals)
    {

    }

    /* WE MAY NEED SEPERATES FOR WOLF PACKS, AS THEY'RE DIFFERENT */
}

