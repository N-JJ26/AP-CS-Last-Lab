package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;

/**
 * FArcticFox
 * 
 * @author Nate Johnson, Austin Benedicto
 * @version 5/14/2025
 */
public class FArcticFox extends ArcticFox implements Female
{
    /**
     * Default constructor for FArcticFox
     * Initializes the FArcticFox object with default values.
     */
    public FArcticFox()
    {
        super();
    }

    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;

        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof ArcticFox))
            return false;

        return false;
    }

    public Animal[] giveBirth()
    {
        return null;
    }

    public boolean isPregnant()
    {
        return false;
    }
}
