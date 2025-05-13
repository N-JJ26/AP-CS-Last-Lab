package src.Plants;

/**
 * abstract Plant
 *
 * @author Mr. DeGroat and Mr. Bouchard
 * @version May 14, 2019
 */
public abstract class Plant
{
    /** 1 km^2 is approximately equal to 247.11 acres */
    public static final double ACRES_PER_SQKM = 247.1053815;
    
    private double totalMass;  //in grams
    private double maxMass;
    private double growthRate;  //in miligrams per gram per day
    private boolean alive;
    
    /**
     * Generates the initial plant mass of the system
     * 
     * @param initialTotalMass the maximum amount of initial dry plant material in grams
     * @param growthRate rate at which the Plant grows in miligrams per gram per day
     */
    public Plant( int initialTotalMass, double growthRate )
    {
        totalMass = initialTotalMass;
        maxMass = initialTotalMass;
        alive = totalMass > 0;
        
        this.growthRate = growthRate;
    }
    
    /**
     * Grows the Plant each day by a Plant specific growth rate of miligrams per gram per day
     */
    public void grow()
    {
        totalMass *= 1 + 0.001 * growthRate * ( 1 - totalMass / maxMass );
    }
    
    /**
     * Called to feed an Herbivore, will return false if Plant is completely consumed
     * 
     * @param gramsPerDay is the rate of consumption by a single Herbivore
     * @return true if there was enough Plant material to feed the Herbivore, false otherwise
     */
    public boolean consumed( double gramsPerDay )
    {
        if( !alive )
            return false;
        
        totalMass -= gramsPerDay;
        
        if( totalMass >= 0 )
            return true;
        
        totalMass = 0;
        alive = false;
        return false;
    }
    
    /**
     * Returns if the Plant is alive or dead
     * 
     * @return true if the Plant is alive, false otherwise
     */
    public boolean isAlive()
    {
        return alive;
    }
    
    /**
     * Returns the total mass of the Plant
     * 
     * @return the total mass of the Plant in grams
     */
    public double getTotalMass()
    {
        return totalMass;
    }
    
    /**
     * Returns the percentage of the initial mass of the Plant remaining
     *  as an integer from 0 - 100
     * 
     * @return the int percentage of the initial mass
     */
    public int getPercentRemaining()
    {
        return (int)( 100 * totalMass / maxMass );
    }
}
