package src.Animal.Consumers;

import src.Animal.*;

/**
 * Female Caribou
 *
 * @author Nate Johnson, Austin Benedicto
 * @version 5/14/2025
 */
public class FCaribou extends Caribou implements Female
{
   private static final int GESTATION_DURATION = 0;
    private int gestationCount;
    private Animal[] litter;
    private int totalBorn;
    private boolean pregnant = false;
    private int interbirthCount;
    
    /**
     * Default constructor for FCaribou
     * Initializes the FCaribou object with default values.
     */
    public FCaribou()
    {
        super();
    }
    /**
     * Returns whether reproduction was successful between two Caribous.
     * 
     * @return true if the animal successfully reproduces, false otherwise.
     */
    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;


        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof Caribou))
            return false;

        return false;
    }

    /**
     * Returns the litter of animals from reproduction.
     * 
     * @return Animal[] the litter as an Animal[]
     */
    public Animal[] giveBirth()
    {
        if(!isAlive() || !pregnant || gestationCount <= GESTATION_DURATION)
            return null;

        for(int i = 0; i < litter.length; i++)
            if(Math.random() < 0.5)
                litter[i] = new ArcticFox();
            else
                litter[i] = new FArcticFox();

        totalBorn += litter.length;
        pregnant = false;
        interbirthCount = 0;

        return litter;
    }

    /**
     * Returns whether the Caribou isPregnant.
     * 
     * @return true if the animal isPregnant, false otherwise.
     */
    public boolean isPregnant()
    {
        return false;
    }
}
