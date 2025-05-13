package src.Animal;

/**
 * <<Female>> is an interface used to handle reproduction
 *
 * @author Mr. DeGroat and Mr. Bouchard
 * @version May 17, 2019
 */
public interface Female
{
    /**
     * Ages the Female by one day and counts days for
     *  gestation or interbirth
     */
    public void aging();
    
    /**
     * Overrides the isAdult() in comparing this age to the onset of female fertility
     * 
     * @return true if the Female is old enough to reproduce, false otherwise
     */
    public boolean isAdult();
    
    /**
     * Checks that a Female can reproduceWith a male, by making sure that it is an alive male
     *  and that the Female is of the appropriate age and not currently pregnant and that 
     *  there was enough time between pregnancies; this method establishes the size of the
     *  litter based on the average and maximum litter sizes
     * 
     * @param male an Animal that should be a male of appropriate species (class)
     * @returns true if the Female was able to reproduceWith the male, false otherwise
     */
    public boolean reproduceWith( Animal male );
    
    /**
     * Returns the litter from a pregnant Female with pseudo-randomly assigned male and Female 
     *  offspring based on the size of the litter determined in reproduceWith()
     * 
     * @returns the Animal[] which may have a length = 0 to the maxLitterSize, or null if the
     *           Female is not alive, not pregant, or has not been pregnant for the full
     *           gestationDuration
     */
    public Animal[] giveBirth();
    
    /**
     * Returns if the Female is pregnant or not
     * 
     * @return true if the Female is pregnant, false otherwise
     */
    public boolean isPregnant();
}
