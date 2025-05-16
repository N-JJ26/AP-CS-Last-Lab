package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;
/**
 * FArcticHare
 * 
 * @author Nate Johnson, Austin Benedicto
 * @version 5/14/2025
 */
public class FArcticHare extends ArcticHare implements Female
{
    /**
     * Default constructor for FArcticHare
     * Initializes the FArcticHare object with default values.
     */
    public FArcticHare()
    {
        super();
    }

    /**
     * Returns whether reproduction was successful between two ArcticHares.
     * 
     * @return true if the animal successfully reproduces, false otherwise.
     */
    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;

        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof ArcticHare))
            return false;

        return false;
    }

    /**
     * Simulates an ArcticHare giving birth to an Animal[] litter.
     * 
     * @return the litter of ArcticHares as an Animal[].
     */
    public Animal[] giveBirth()
    {
        return null;
    }

    /**
     * Returns whether the ArcticHare isPregnant.
     * 
     * @return true if the animal isPregnant, false otherwise.
     */
    public boolean isPregnant()
    {
        return false;
    }

    /**
     * Simulates the ArcticHare aging one (1) day.
     */
    public void aging()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aging'");
    }

    /**
     * Returns whether the animal is an adult.
     * 
     * @return true if the animal is an adult, false otherewise.
     */
    public boolean isAdult()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAdult'");
    }
}
