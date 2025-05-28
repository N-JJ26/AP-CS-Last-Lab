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
        beginningSequence();
    }

    private static void beginningSequence()
    {
        plants[0] = new ArcticDaisy();
        plants[1] = new ArcticWillow();
        plants[2] = new CaribouMoss();

        System.out.print("Animals (number of adults):\nArctic Foxes = ");
        animals[0] = new ArcticFox[in.nextInt()];

        System.out.print("Arctic Hares = ");
        animals[1] = new ArcticHare[in.nextInt()];

        System.out.print("Caribous = ");
        animals[2] = new Caribou[in.nextInt()];

        System.out.print("Polar Bears = ");
        animals[3] = new PolarBear[in.nextInt()];

        System.out.print("Tundra Wolves = ");
        animals[4] = new TundraWolf[in.nextInt()];
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
