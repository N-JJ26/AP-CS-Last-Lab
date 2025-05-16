package src.Animal.Consumers;

import src.Animal.*;

/**
 * Female Caribou
 *
 * @author Nate Johnson
 * @version 5/14/2025
 */
public class FCaribou extends Caribou implements Female
{
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
        return null;
    }

    public boolean isPregnant()
    {
        return false;
    }
}
