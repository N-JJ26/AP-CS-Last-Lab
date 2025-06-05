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

    private static final int HUNTS_PER_DAY = 3;

    private static Plant[] plants = new Plant[NUM_PLANTS];
    private static Animal[][] animals = new Animal[NUM_ANIMALS][];

    private static int daisyIndex = 0;
    private static int willowIndex = 1;
    private static int mossIndex = 2;

    private static int foxIndex = 0;
    private static int hareIndex = 1;
    private static int caribouIndex = 2;
    private static int polarBearIndex = 3;
    private static int wolfIndex = 4;

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
        plants[daisyIndex] = new ArcticDaisy(in.nextInt());

        System.out.print("Arctic Willow = ");
        plants[willowIndex] = new ArcticWillow(in.nextInt());

        System.out.print("Caribou Moss = ");
        plants[mossIndex] = new CaribouMoss(in.nextInt());

        System.out.print("\nAnimals (initial number of adults):\nArctic Foxes = ");
        animals[foxIndex] = new ArcticFox[in.nextInt()];

        System.out.print("Arctic Hares = ");
        animals[hareIndex] = new ArcticHare[in.nextInt()];

        System.out.print("Caribous = ");
        animals[caribouIndex] = new Caribou[in.nextInt()];

        System.out.print("Polar Bears = ");
        animals[polarBearIndex] = new PolarBear[in.nextInt()];

        System.out.print("Tundra Wolves (multiple of 6) = ");
        animals[wolfIndex] = new TundraWolf[in.nextInt()];

        System.out.println();

        information();
    }

    private static void runSimulation() {
        
    }

    private static void information() {
        System.out.printf("Daisies: %d percent; Willows: %d percent; Moss %d percent\n",
                        plants[daisyIndex].getPercentRemaining(),
                        plants[willowIndex].getPercentRemaining(),
                        plants[mossIndex].getPercentRemaining());
        System.out.printf("Foxes %d; Hares %d; Caribous %d; Polar Bears %d; Wolves %d\n",
                        animals[foxIndex].length,
                        animals[hareIndex].length,
                        animals[caribouIndex].length,
                        animals[polarBearIndex].length,
                        animals[wolfIndex].length);
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

    private static void shuffleAnimals()
    {
        for( int i = 0; i < animals.length; i++ )
        {
            int index = ( int )( Math.random() * NUM_ANIMALS);

            Animal[] temp = animals[i];
            animals[i] = animals[index];
            animals[index] = temp;
        }
    }

    private static void shufflePlants()
    {
        for(int i = 0; i < plants.length; i++)
        {
            int index = ( int )( Math.random() * NUM_PLANTS);

            Plant temp = plants[i];
            plants[i] = plants[index];
            plants[index] = temp;
        }
    }

    private static void reassignIndex()
    {
        int index = 0;
        while( animals[index][0] instanceof ArcticFox && index < animals.length )
        {
            foxIndex++;
            index++;
        }
        index = 0;
        while( animals[index][0] instanceof ArcticHare && index < animals.length )
        {
            hareIndex++;
            index++;
        }
        index = 0;
        while( animals[index][0] instanceof Caribou && index < animals.length )
        {
            caribouIndex++;
            index++;
        }
        index = 0;
        while( animals[index][0] instanceof PolarBear && index < animals.length )
        {
            polarBearIndex++;
            index++;
        }
        index = 0;
        while( animals[index][0] instanceof TundraWolf && index < animals.length )
        {
            wolfIndex++;
            index++;
        }
        index = 0;
        while( plants[index] instanceof ArcticDaisy && index < animals.length )
        {
            daisyIndex++;
            index++;
        }
        index = 0;
        while( plants[index] instanceof ArcticWillow && index < animals.length )
        {
            willowIndex++;
            index++;
        }
        index = 0;
        while( plants[index] instanceof CaribouMoss && index < animals.length )
        {
            mossIndex++;
            index++;
        }
    }

    private static void shuffleAll() {
        for(int i = 0; i < animals.length; i++)
            shuffle(animals[i]);
        shuffleAnimals();
        shufflePlants();
        reassignIndex();
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


        for (int i = 0; i < birthingAnimals.length; i++)
        {
            Animal animal = birthingAnimals[i];
            allAnimals.add(animal);
            if (animal instanceof Female)
                females.add(animal);
        }

        for (int i = 0; i < females.size(); i++)
        {
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
    /**
     * Note that this is untested as hell (but so is half of runner lmao)
     * 
     * @param animals animals or smn idk
     */
    private static void eat( Animal[] animals )
    {
        for( int i = 0; i < animals.length; i++ ) 
        {
            if(animals instanceof ArcticFox[]) 
            {
                int index = 0;
                while(index < plants.length)
                {
                    ArcticFox f = (ArcticFox)(animals[i]);
                    if(!f.choose(animals[index], plants[index]))
                    {
                        index++;
                        continue;
                    }
                break;
                }
            }
            else if( animals[i] instanceof Carnivore )
            {
                Carnivore c = (Carnivore)(animals[i]);
                runCarnivore(c);
            }
            else 
            {
                Herbivore h = (Herbivore)(animals[i]);
                h.eat(plants[i]);
                break;
            }
        }
    }

    private static void runCarnivore( Carnivore carn )
    {
        int numTries = 0;
        int index = 0;

        while( numTries < HUNTS_PER_DAY )
        {
            if( !carn.eat( animals[ index ][ 0 ] ) )
            {
                index++;
                continue;
            }
            break;
        }
    }

    private static void runHerbivore( Herbivore herb )
    {
        int index = 0;
        while( index < plants.length )
        {
            if( !herb.eat( plants[ index ] ) )
            {
                index++;
                continue;
            }
            break;
        }
    }
}
