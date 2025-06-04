package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;
import src.Animal.Herbivore;
import src.Plants.*;
import src.Plants.Producers.ArcticDaisy;
import src.Plants.Producers.ArcticWillow;


/**
 * The Arctic Fox in the Tundra biome
 *
 * @author Nate Johnson, Austin Benedicto, Avi D.
 * @version 5/27/2025
 */
public class ArcticFox extends Animal implements Carnivore, Herbivore
{
    private static final int BODY_MASS_NEWBORN = 50;
    private static final int BODY_MASS_ADULT = 5200;
    private static final int WEANING_AGE = 14;
    private static final int ONSET_FERTILITY_MALE = 304;
    private static final double MAX_LIFE_SPAN = 9999.9; //TODO
    private static final int DAYS_WITHOUT_FOOD = 99; //TODO

    private static final double HUNTING_EFFICIENCY = 0.6;
    private static final double HUNTING_EFFICIENCY_RANGE = 0.14;

    // 90% chance Arctic Fox will choose an animal over a plant (TODO)
    private static final double PROBABILITY_HUNT_ANIMAL = 0.9;

    private final double GRAMS_PER_DAY;

    private boolean hasEaten;
    private int daysWithoutEating = 0;

    private int gramsEaten;

    /**
     * Constructs an Arctic Fox object via Animal().
     */
    public ArcticFox()
    {
        super( BODY_MASS_NEWBORN + ( int )( Math.random() * 7 ), BODY_MASS_ADULT,
                WEANING_AGE + ( int )( Math.random() * 11 ), ONSET_FERTILITY_MALE, MAX_LIFE_SPAN );

        gramsEaten = 0;
        GRAMS_PER_DAY = this.massPerDay();
    }

    /**
     * Initializes an ArcticFox with an age input
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
     * Simulates an ArcticFox eating another Animal. TODO
     */
    public boolean eat( Animal a )
    {
        if( isHungry() && wasHuntSuccessful() && a instanceof ArcticHare) {
            gramsEaten += TROPHIC_EFFICIENCY_RULE * a.getCarcass();
            a.died();
            return true;
        }
        return false;
    }

    /**
     * Simulates an ArcticFox eating a plant. TODO
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
     * Decides whether an ArcticFox hunts for plants or animals. TODO (as of now 1:9)
     * 
     * @return '0' if going after an animal or '1' if after a plant
     */
    public int choose()
    {
        if( (Math.random() ) > PROBABILITY_HUNT_ANIMAL )
            return( 1 );
        else
            return( 0 );
        
    }

    /**
     * Simulates aging one day
     */
    public void aging()
    {
        super.aging();

        if(hasEaten) {
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
