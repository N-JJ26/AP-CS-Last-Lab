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

    private static Plant[] plants = new Plant[NUM_PLANTS];
    private static Animal[][] animals = new Animal[NUM_ANIMALS][];

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        beginningSequence();
    }

    private static void beginningSequence()
    {
        System.out.print("Enter the acres of each plant:\nArctic Daisies = ");
        plants[0] = new ArcticDaisy(in.nextInt());
        in.next();

        System.out.print("Arctic Willow = ");
        plants[1] = new ArcticWillow(in.nextInt());
        in.next();

        System.out.print("Caribou Moss = ");
        plants[2] = new CaribouMoss(in.nextInt());
        in.next();

        System.out.print("Animals (initial number of adults):\nArctic Foxes = ");
        animals[0] = new ArcticFox[in.nextInt()];
        in.next();

        System.out.print("Arctic Hares = ");
        animals[1] = new ArcticHare[in.nextInt()];
        in.next();

        System.out.print("Caribous = ");
        animals[2] = new Caribou[in.nextInt()];
        in.next();

        System.out.print("Polar Bears = ");
        animals[3] = new PolarBear[in.nextInt()];
        in.next();

        System.out.print("Tundra Wolves = ");
        animals[4] = new TundraWolf[in.nextInt()];
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
