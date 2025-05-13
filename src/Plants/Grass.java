package src.Plants;

/**
 * class Grass
 *
 * @author Mr. DeGroat and Mr. Bouchard
 * @version May 7, 2019
 */
public class Grass extends Plant
{
    private static final int plantingDensity = 43560;  //individuals per acre
    private static final int initialMass = 25;  //individual plant dry mass in grams
    private static final double growthRate = 93.73;  //miligrams per gram per day
    
    /**
     * generates all of the initial Grass plants
     * 
     * @param sqkm is the starting number of km^2 of Grass plants
     */
    public Grass( int sqkm )
    {
        // acres * individual/acre * grams/individual = grams
        super( (int)( sqkm * ACRES_PER_SQKM * plantingDensity * initialMass ), growthRate );
    }
}

