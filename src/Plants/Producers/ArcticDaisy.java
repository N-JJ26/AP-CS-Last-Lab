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
    private static final double GROWTH_RATE = 20.0;  //miligrams per gram per day
    private static final double MAX_MASS = 1.5;  
    
    /**
     * Constructs the ArcticDaisy with an initial mass of 0.35 grams
     *  and a growth rate of 20mg/g/day.
     */
    public ArcticDaisy( )
    {
        // acres * individual/acre * grams/individual = grams
        super( INITIAL_MASS, GROWTH_RATE, MAX_MASS );
    }
}
