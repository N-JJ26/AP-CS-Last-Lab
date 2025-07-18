package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Herbivore;
import src.Plants.Plant;

/**
 * Caribou class represents a herbivorous animal that can be found in the Arctic region.
 * It extends the Animal class and implements the Herbivore interface.
 * 
 * @author Austin Benedicto, Nate Johnson, Avi D.
 * @version 6/5/2025
 */
public class Caribou extends Animal implements Herbivore
{
    private static final int DAYS_WITHOUT_FOOD = 14;
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0;

    private final double GRAMS_PER_DAY;

    private boolean hasEaten;
    private int daysWithoutEating;

    /**
     * Constructs a new Caribou with default newborn values.
     * Initializes the caribou's mass, age, and other biological parameters.
     */
    public Caribou()
    {
        super( BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN );

        hasEaten = false;
        daysWithoutEating = 0;
        GRAMS_PER_DAY = this.massPerDay();
    }

    /**
     * Constructs a new Caribou with a specified initial age.
     * Ages the caribou by the given number of days without consequences.
     *
     * @param age the initial age (in days) of the Caribou
     */
    public Caribou(int age)
    {
        this();

        for(int i = 0; i < age; i++)
            super.agingWithoutConsequence();
        
    }

    /**
     * Simulates a Caribou eating another plant.
     */
    public boolean eat( Plant p )
    {
        if( p.consumed( GRAMS_PER_DAY ) )
        {
            hasEaten = true;
            return true;
        }
        return false;
    }

    /**
     * Returns whether the animal isHungry
     *
     * @return true if the animal is hungry, false otherwise.
     */
    public boolean isHungry()
    {
        return !hasEaten;
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
     * Simulates a Caribou being eaten and turned into a carcass.
     *
     * @return the mass of the Caribou carcass
     */
    public int getCarcass()
    {
        if( !isAlive() )
            return 0; // If there's a dead Caribou, we're NOT going to have it be scavenged. May be redundant depending on Runner
        
        super.died(); // For future reference, make sure Runner doesnt delete the Animal before getCarcass() is called
        return( super.getCarcass() );
    }

    /**
     * The String "Caribou is x days old, and is alive: true/false."
     *
     * @return the age and isAlive of the Animal
     */
    public String toString()
    {
        return "Caribou " + super.toString();
    }
}
