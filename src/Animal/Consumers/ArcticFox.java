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
 * @author Nate Johnson, Austin Benedicto
 * @version 5/20/2025
 */
public class ArcticFox extends Animal implements Carnivore, Herbivore
{
    private static final int BODY_MASS_NEWBORN = 50;
    private static final int BODY_MASS_ADULT = 5200;
    private static final int WEANING_AGE = 14;
    private static final int ONSET_FERTILITY_MALE = 304;
    private static final double MAX_LIFE_SPAN = 16.3;

    private static final double HUNTING_EFFICIENCY = 0.6;
    private static final double HUNTING_EFFICIENCY_RANGE = 0.14;
    private static final int GRAMS_PER_DAY = 750;

    private int gramsEaten;

    /**
     * Constructs an Arctic Fox object via Animal().
     */
    public ArcticFox()
    {
        super( BODY_MASS_NEWBORN + ( int )( Math.random() * 7 ), BODY_MASS_ADULT,
                WEANING_AGE + ( int )( Math.random() * 11 ), ONSET_FERTILITY_MALE, MAX_LIFE_SPAN );

        gramsEaten = 0;
    }

    /**
     * Returns whether the animal isHungry
     * 
     * @return true if the animal is hungry, false otherwise.
     */
    public boolean isHungry()
    {
        return gramsEaten == GRAMS_PER_DAY;
    }

    /**
     * Simulates an ArcticFox eating another Animal.
     */
    public void eat( Animal a )
    {
        if(!isHungry() && wasHuntSuccessful() && a instanceof ArcticHare)
            gramsEaten += TROPHIC_EFFICIENCY_RULE * a.getCarcass();
    }

    /**
     * Simulates an ArcticFox eating a plant.
     */
    public void eat( Plant p )
    {
        if(!isHungry() && (p instanceof ArcticDaisy || p instanceof ArcticWillow))
        {
            p.consumed(GRAMS_PER_DAY - gramsEaten);
            gramsEaten += GRAMS_PER_DAY;
        }
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

    public void aging()
    {
        super.aging();

        gramsEaten = 0;
    }

    /**
     * Returns "Arctic Fox " + Animals toString() which gives the age and whether or not
     *  this ArcticFox is alive
     *
     * @return "Arctic Fox " + Animal.toString()
     */
    public String toString()
    {
        return "Arctic Fox " + super.toString();
    }
}
