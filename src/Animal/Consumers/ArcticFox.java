package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;
import src.Animal.Herbivore;
import src.Plants.*;

/**
 * The Arctic Fox in the Tundra biome
 *
 * @author Nate Johnson
 * @version 5/15/2025
 */
public class ArcticFox extends Animal implements Carnivore, Herbivore {
    /*TODO:
     * finish up code
     */

    private static final int BODY_MASS_NEWBORN = 50;
    private static final int BODY_MASS_ADULT = 5200;
    private static final int WEANING_AGE = 14;
    private static final int ONSET_FERTILITY_MALE = 304;
    private static final double MAX_LIFE_SPAN = 16.3;

    private static final double HUNTING_EFFICIENCY = 0.6;
    private static final double HUNTING_EFFICIENCY_RANGE = 0.14;

    /**
     * Constructs an Arctic Fox object via Animal().
     */
    public ArcticFox()
    {
        super( BODY_MASS_NEWBORN + ( int )( Math.random() * 7 ), BODY_MASS_ADULT,
                WEANING_AGE + ( int )( Math.random() * 11 ), ONSET_FERTILITY_MALE, MAX_LIFE_SPAN );
    }

    /**
     * Returns whether the animal isHungry
     * 
     * @return true if the animal is hungry, false otherwise.
     */
    public boolean isHungry()
    {
        return false;
    }
    /**
     * Simulates an ArcticFox eating another Animal.
     */
    public void eat( Animal a )
    {
        return;
    }
    /**
     * Simulates an ArcticFox eating a plant.
     */
    public void eat( Plant p )
    {
        return;
    }

    /**
     * Returns whether or not the hunt was successful,
     *  based of a chance between 60 and 73 percent
     */
    public boolean wasHuntSuccessful()
    {
        return Math.random() < HUNTING_EFFICIENCY + Math.random() * HUNTING_EFFICIENCY_RANGE;
    }

    /**
     * Returns "Arctic Fox" + Animals toString() which gives the age and whether or not
     *  this ArcticFox is alive
     *
     * @return "Arctic Fox" + Animal.toString()
     */
    public String toString()
    {
        return "Arctic Fox" + super.toString();
    }
}
