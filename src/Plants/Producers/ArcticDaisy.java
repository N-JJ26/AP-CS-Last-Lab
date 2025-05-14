package src.Plants.Producers;

/**
 * class Artic Daisy
 *
 * @author Avi D.
 * @version 5/14/2025
 */
public class ArcticDaisy extends Plant
{
    private static final int INITIAL_MASS = 0.35;  //individual ArcticDaisy dry mass in grams
    private static final double GROWTH_RATE = 20.0;  //miligrams per gram per day
    
    /**
     * generates all of the ArcticDaisies
     * 
     */
    public ArcticDaisy( )
    {
        // acres * individual/acre * grams/individual = grams
        super( INITIAL_MASS, GROWTH_RATE );
    }
}
