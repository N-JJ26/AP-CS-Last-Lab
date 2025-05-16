package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;

public class FPolarBear extends PolarBear implements Female
{
    /**
     * Default constructor for FPolarBear
     * Initializes the FPolarBear object with default values.
     */
    public FPolarBear()
    {
        super();
    }

    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;

        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof PolarBear))
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPregnant'");
    }
}
