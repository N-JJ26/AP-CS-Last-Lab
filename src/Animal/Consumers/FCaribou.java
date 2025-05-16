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
    /**
     * Default constructor for FCaribou
     * Initializes the FCaribou object with default values.
     */
    public FCaribou()
    {
        super();
    }

    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;


        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof Caribou))
            return false;

        return false;
    }

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

    public boolean isPregnant()
    {
        return false;
    }
}
