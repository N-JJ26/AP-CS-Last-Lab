package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;

/**
 * TundraWolf class represents a carnivorous animal that can be found in the Arctic region.
 * It extends the Animal class and implements the Carnivore interface.
 * 
 * @author Austin Benedicto, Avi Dasgupta, Nathaniel Johnspon
 * @version 5/27/2025
 */
public class TundraWolf extends Animal implements Carnivore
{
    /** how many TundraWolfs are in a pack */
    public static final int PACK_SIZE = 6;

    private static final int DAYS_WITHOUT_FOOD = 999; //TODO
    private static final int BODY_MASS_NEW_BORN = 450;
    private static final int BODY_MASS_ADULT = 26625;
    private static final int ONSET_FERT_MALE = 669;
    private static final double MAX_LIFE_SPAN = 7 * (365); // in years
    //private static final int WEANING_AGE = 120; //TODO
    private static final double HUNTING_EFFICIENCY = 0.2;
    
    private int daysWithoutEating;
    private double gramsEaten;
    private final double GRAMS_PER_DAY;

    /**
     * Constructs a TundraWolf object, incrementing the total number of Animals and total live Animals;
     *  sets the maximum life span of an Animal as well as body masses
     */
    public TundraWolf()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, (int)(Math.random()*69) + 40, ONSET_FERT_MALE, MAX_LIFE_SPAN);

        GRAMS_PER_DAY = this.massPerDay();

        gramsEaten = 0;
        daysWithoutEating = 0;
    }

    /**
     * Initializes a TundraWolf with an age input
     */
    public TundraWolf(int age)
    {
        this();

        for(int i = 0; i < age; i++)
            super.agingWithoutConsequence();
    }

    /**
     * Simulates a TundraWolf eating an Animal.
     */
    public boolean eat(Animal a)
    {
        if(isAlive() && wasHuntSuccessful() && isHungry() &&
            (a instanceof Caribou || a instanceof ArcticHare || a instanceof ArcticFox))
        {
            gramsEaten += TROPHIC_EFFICIENCY_RULE * a.getCarcass() / PACK_SIZE;
            a.died();
            return true;
        }
        return false;
    }

    /**
     * Returns whether the hunt was successful.
     * 
     * @return true if the hunt was successful, false otherwise.
     */
    public boolean wasHuntSuccessful()
    {
        return Math.random() < HUNTING_EFFICIENCY;
    }
    
    /**
     * Returns whether the TundraWolf isHungry().
     * 
     * @return true if the animal isHungry, false otherwise.
     */
    public boolean isHungry()
    {
        return( gramsEaten < GRAMS_PER_DAY );
    }

    /**
     * Simulates aging one day
     */
    public void aging()
    {
        super.aging();

        if(isHungry())
        {
            daysWithoutEating = 0;
        }
        else
            daysWithoutEating++;

        gramsEaten = 0;
        
        if(daysWithoutEating > DAYS_WITHOUT_FOOD)
            super.died();
    }

    /**
     * The String "Tundra Wolf is x days old, and is alive: true/false."
     *
     * @return the age and isAlive of the Animal
     */
    public String toString()
    {
        return "Tundra Wolf " + super.toString();
    }
}
