package src.Animal.Consumers;
import src.Animal.Animal;
import src.Animal.Herbivore;
import src.Plants.Plant;

/**
 * Caribou class represents a herbivorous animal that can be found in the Arctic region.
 * It extends the Animal class and implements the Herbivore interface.
 * 
 * @author Austin Benedicto, Nate Johnson
 * @version 5/14/2025
 */
public class Caribou extends Animal implements Herbivore
{
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0; // in years
    private static final int GRAMS_PER_DAY = 5000;

    private boolean hasEaten;

    public Caribou()
    {
        super( BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN );

        hasEaten = false;
    }

    public void eat( Plant p )
    {
        p.consumed( GRAMS_PER_DAY );

        hasEaten = true;
    }

    public boolean isHungry()
    {
        return hasEaten;
    }

    public void resetDay()
    {
        hasEaten = false;
    }
}
