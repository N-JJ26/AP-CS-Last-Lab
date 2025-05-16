package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Herbivore;
import src.Plants.Plant;

public class ArcticHare extends Animal implements Herbivore
{
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0; // in years
    private static final int GRAMS_PER_DAY = 0; //TODO: put in constants

    private boolean hasEaten;

    /**
     * Creates a new ArcticHare object via Animal().
     */
    public ArcticHare()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN);
        hasEaten = false;
    }

    /**
     * Simulates an ArcticHare eating another plant.
     */
     /**
     * Simulates a Caribou eating another plant.
     */
    public void eat( Plant p )
    {
        p.consumed( GRAMS_PER_DAY );

        hasEaten = true;
    }
    
    /**
     * Returns whether the animal isHungry
     * 
     * @return true if the animal is hungry, false otherwise.
     */
    public boolean isHungry()
    {
        return hasEaten;
    }
}
