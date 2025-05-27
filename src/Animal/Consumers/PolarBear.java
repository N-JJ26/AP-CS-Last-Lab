package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;

/**
 * PolarBear class represents a carnivorous animal that can be found in the Arctic region.
 * It extends the Animal class and implements the Carnivore interface.
 * 
 * @author Austin Benedicto, Avi Dasgupta
 * @version 5/27/2025
 */

 //TODO: ADD IN SOME OTHER STUFF
public class PolarBear extends Animal implements Carnivore
{
    private static final int DAYS_WITHOUT_FOOD = 9999; //TODO
    private static final int BODY_MASS_NEW_BORN = 600;
    private static final int BODY_MASS_ADULT = 500000;
    private static final int WEANING_AGE = 900;
    private static final int ONSET_FERT_MALE = 2190;
    private static final double MAX_LIFE_SPAN = 30 * (365); // in years
    private static final double HUNTING_EFFICIENCY = 0.92;

    private boolean hasEaten;
    private int daysWithoutEating = 0;

    /**
     * Constructs a PolarBear object via Animal().
     */
    public PolarBear()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN);
    }

    /**
     * Initializes a PolarBear with an age input
     */
    public PolarBear(int age)
    {
        this();

        for(int i = 0; i < age; i++)
            super.agingWithoutConsequence();
    }

    /**
     * Determines whether or not the hunt was successful,
     *  based of a chance between 60 and 73 percent
     */
    public void eat(Animal a)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eat'");
    }

    /**
     * Returns whether or not the hunt was successful as a boolean
     * 
     * @return true if it was successful, false otherwise.
     */
    public boolean wasHuntSuccessful()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'wasHuntSuccessful'");
    }

    /**
     * Returns whether the PolarBear isHungry().
     *  
     * @return true if the PolarBear isHungry, false otherwise.
     */
    public boolean isHungry()
    {
        return( !hasEaten );
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
    
    //TODO: Implement the getCarcass method
    public int getCarcass()
    {
        return 0;
    }

    /**
     * The String "Polar Bear is x days old, and is alive: true/false."
     *
     * @return the age and isAlive of the Animal
     */
    public String toString()
    {
        return "Arctic Fox " + super.toString();
    }
}
