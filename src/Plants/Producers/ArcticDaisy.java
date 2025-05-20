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
    private static final int INITIAL_MASS = 20;  //individual ArcticDaisy dry mass in grams
    private static final double GROWTH_RATE = 0.35;  //miligrams per gram per day
    private static final double MAX_MASS = 100.0;  //maximum mass of this plant in grams TODO!!!!!!!!!!
    
    /**
     * generates all of the ArcticDaisies
     * 
     */
    public ArcticDaisy( )
    {
        // acres * individual/acre * grams/individual = grams
        super( INITIAL_MASS, GROWTH_RATE, MAX_MASS );
    }
}
