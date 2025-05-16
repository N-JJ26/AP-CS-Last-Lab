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

    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;

        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof ArcticHare))
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

    @Override
    public void aging()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'aging'");
    }

    @Override
    public boolean isAdult()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAdult'");
    }
}
