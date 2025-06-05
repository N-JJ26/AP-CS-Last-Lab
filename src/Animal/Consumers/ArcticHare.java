package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Herbivore;
import src.Plants.Plant;

/**
 * Represents an Arctic Hare in the tundra biome.
 * This class models the biological and behavioral characteristics of the Arctic Hare,
 * including its growth, eating habits, and survival logic.
 *
 * @author Nate Johnson, Avi D., Austin Benedicto
 * @version 6/5/2025
 */
public class ArcticHare extends Animal implements Herbivore
{
    private static final int DAYS_WITHOUT_FOOD = 1;
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0;

    private final double GRAMS_PER_DAY;

    private boolean hasEaten;
    private int daysWithoutEating;

    /**
     * Constructs a new ArcticHare with default newborn values.
     * Initializes the hare's mass, age, and other biological parameters.
     */
    public ArcticHare()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN);

        hasEaten = false;
        daysWithoutEating = 0;
        GRAMS_PER_DAY = this.massPerDay();
    }

    /**
     * Constructs a new ArcticHare with a specified initial age.
     * Ages the hare by the given number of days without consequences.
     *
     * @param age the initial age (in days) of the Arctic Hare
     */
    public ArcticHare(int age)
    {
        this();

        for(int i = 0; i < age; i++)
            super.agingWithoutConsequence();
    }

    /**
     * Simulates an ArcticHare eating another plant.
     */
    public boolean eat(Plant p) 
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
     * The String "Arctic Hare is x days old, and is alive: true/false."
     *
     * @return the age and isAlive of the Animal
     */
    public String toString()
    {
        return "Arctic Hare " + super.toString();
    }
}
