package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Herbivore;
import src.Plants.Plant;

/**
 * The Arctic Hare in the tundra biome
 *
 * @author Nate Johnson
 * @version 5/20/2025
 */
public class ArcticHare extends Animal implements Herbivore
{
    private static final int DAYS_WITHOUT_FOOD = 1;
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0;
    private static final int GRAMS_PER_DAY = 350;

    private boolean hasEaten;
    private int daysWithoutEating;

    /**
     * Creates a new ArcticHare object via Animal().
     */
    public ArcticHare()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN);

        hasEaten = false;
        daysWithoutEating = 0;
    }

    /**
     * Simulates an ArcticHare eating another plant.
     */
    public void eat(Plant p) {
        p.consumed(GRAMS_PER_DAY);

        hasEaten = true;
    }
    
    /**
     * Returns whether the animal isHungry
     * 
     * @return true if the animal is hungry, false otherwise.
     */
    public boolean isHungry() {
        return hasEaten;
    }

    /**
     * Ages the ArcticHare by one day, and tells the ArcticHare
     *  that it hasn't eaten in the day
     */
    public void aging()
    {
        super.aging();

        hasEaten = false;
    }

    public String toString()
    {
        return "Arctic Hare " + super.toString();
    }
}
