package src.Animal.Consumers;
import src.Animal.Animal;
import src.Animal.Herbivore;
import src.Plants.Plant;
import src.Plants.Producers.CaribouMoss;

/**
 * Caribou class represents a herbivorous animal that can be found in the Arctic region.
 * It extends the Animal class and implements the Herbivore interface.
 * 
 * @author Austin Benedicto, Nate Johnson, Avi D.
 * @version 5/22/2025
 */
public class Caribou extends Animal implements Herbivore
{
    private static final int DAYS_WITHOUT_FOOD = 14;
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0;
    private static final int GRAMS_PER_DAY = 750; //TODO

    private boolean hasEaten;
    private int daysWithoutEating;

    /**
     * Creates a new Caribou object via Animal().
     */
    public Caribou()
    {
        super( BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN );

        hasEaten = false;
        daysWithoutEating = 0;
    }

    /**
     * Initializes a Caribou with an age input
     */
    public Caribou(int age)
    {
        this();

        for(int i = 0; i < age; i++)
            super.aging();
    }

    /**
     * Simulates a Caribou eating another plant.
     */
    public void eat( Plant p )
    {
        if( p.consumed( GRAMS_PER_DAY ) )
            hasEaten = true;
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

    public String toString()
    {
        return "Caribou " + super.toString();
    }
}
