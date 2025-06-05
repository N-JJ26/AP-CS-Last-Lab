package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;
import src.Animal.Herbivore;
import src.Plants.*;
import src.Plants.Producers.ArcticDaisy;
import src.Plants.Producers.ArcticWillow;


/**
 * Represents an Arctic Fox in the Tundra biome.
 * This class models the biological and behavioral characteristics of the Arctic Fox,
 * including its omnivorous diet, hunting efficiency, and survival logic.
 *
 * @author Nate Johnson, Austin Benedicto, Avi D.
 * @version 6/5/2025
 */
public class ArcticFox extends Animal implements Carnivore, Herbivore
{
    private static final int BODY_MASS_NEWBORN = 50;
    private static final int BODY_MASS_ADULT = 5200;
    private static final int WEANING_AGE = 14;
    private static final int ONSET_FERTILITY_MALE = 304;
    private static final double MAX_LIFE_SPAN = 1642.5;
    private static final int DAYS_WITHOUT_FOOD = 28;

    private static final double HUNTING_EFFICIENCY = 0.6;
    private static final double HUNTING_EFFICIENCY_RANGE = 0.14;

    private static final double PROBABILITY_HUNT_ANIMAL = 0.5;

    private final double GRAMS_PER_DAY;

    private boolean hasEaten;
    private int daysWithoutEating = 0;

    private int gramsEaten;

    /**
     * The two choices for an Arctic Fox in the eating phase of the simulation.
     * Determines whether the fox will act as a herbivore or carnivore during feeding.
     */
    public enum Choice
    {
        HERBIVORE,
        CARNIVORE
    }

    /**
     * Constructs a new ArcticFox with randomized newborn values for mass and weaning age.
     * Initializes the fox's biological parameters and daily food requirements.
     */
    public ArcticFox()
    {
        super( BODY_MASS_NEWBORN + ( int )( Math.random() * 7 ), BODY_MASS_ADULT,
                WEANING_AGE + ( int )( Math.random() * 11 ), ONSET_FERTILITY_MALE, MAX_LIFE_SPAN );

        gramsEaten = 0;
        GRAMS_PER_DAY = this.massPerDay();
    }

    /**
     * Initializes an ArcticFox with a specified initial age.
     * Ages the fox by the given number of days without consequences.
     *
     * @param age the initial age (in days) of the Arctic Fox
     */
    public ArcticFox(int age)
    {
        this();

        for(int i = 0; i < age; i++)
            super.agingWithoutConsequence();
    }

    /**
     * Returns whether the animal isHungry
     * 
     * @return true if the animal is hungry, false otherwise.
     */
    public boolean isHungry()
    {
        return( gramsEaten > GRAMS_PER_DAY );
    }

    /**
     * Simulates an ArcticFox eating another Animal.
     */
    public boolean eat( Animal a )
    {
        if( a.isAlive() && isHungry() && wasHuntSuccessful() && a instanceof ArcticHare) {
            gramsEaten += TROPHIC_EFFICIENCY_RULE * a.getCarcass();
            a.died();
            return true;
        }
        return false;
    }

    /**
     * Simulates an ArcticFox eating a plant.
     */
    public boolean eat( Plant p )
    {
        if( isHungry() && (p instanceof ArcticDaisy || p instanceof ArcticWillow))
        {
            p.consumed(GRAMS_PER_DAY - gramsEaten);
            gramsEaten += GRAMS_PER_DAY;
            return true;
        }
        return false;
    }

    /**
     * Returns whether or not the hunt was successful,
     *  based of a chance between 60 and 73 percent
     *
     * @return whether or not the hunt was successful
     */
    public boolean wasHuntSuccessful()
    {
        return Math.random() < HUNTING_EFFICIENCY + Math.random() * HUNTING_EFFICIENCY_RANGE;
    }

    /**
     * Decides whether an ArcticFox hunts for plants or animals, and calls the respective method.
     * 
     * @return true if hunt was successfull, false otherwise
     */
    public boolean choose(Animal a, Plant p)
    {
        if( (Math.random() ) > PROBABILITY_HUNT_ANIMAL )
            return eat( p );
        else
            return eat( a );
    }

    /**
     * Simulates aging one day
     */
    public void aging()
    {
        super.aging();

        if(hasEaten)
        {
            hasEaten = false;
            daysWithoutEating = 0;
        }
        else
            daysWithoutEating++;
        
        if(daysWithoutEating > DAYS_WITHOUT_FOOD)
            super.died();
    }
    
    /**
     * The String "Arctic Fox is x days old, and is alive: true/false."
     *
     * @return the age and isAlive of the Animal
     */
    public String toString()
    {
        return "Arctic Fox " + super.toString();
    }
}
