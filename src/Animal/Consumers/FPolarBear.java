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

    /**
     * Returns whether reproduction was successful between two Polar Bears.
     * 
     * @return true if the animal successfully reproduces, false otherwise.
     */
    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;

        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof PolarBear))
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'giveBirth'");
    }

    /**
     * Returns whether the PolarBear isPregnant.
     * 
     * @return true if the animal isPregnant, false otherwise.
     */
    public boolean isPregnant()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPregnant'");
    }
}
