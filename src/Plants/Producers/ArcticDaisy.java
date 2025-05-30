package src.Plants.Producers;
import src.Plants.Plant;

/**
 * class Artic Daisy
 *
 * @author Avi D.
 * @version 5/14/2025
 */
public class ArcticDaisy extends Plant
{
    private static final double INITIAL_MASS = 0.35;  //individual ArcticDaisy dry mass in grams
    private static final double GROWTH_RATE = 20.0;
    private static final int POPULATION_DENSITY = 100000;
    
    /**
     * Constructs the ArcticDaisy with an initial mass of 0.35 grams
     *  and a growth rate of 20mg/g/day.
     */
    public ArcticDaisy( int acres )
    {
        // acres * individual/acre * grams/individual = grams
        super( (int)(acres * INITIAL_MASS * POPULATION_DENSITY), GROWTH_RATE );
    }
}
