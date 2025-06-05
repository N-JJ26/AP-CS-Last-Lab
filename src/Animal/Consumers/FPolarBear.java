package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;

/**
 * FPolarBear is the Female extension of PolarBear
 * 
 * @author Nate Johnson, Austin Benedicto, Avi D.
 * @version 6/5/2025
 */
public class FPolarBear extends PolarBear implements Female
{
    private static final int GESTATION_DURATION = 365;
    private static final int MAX_LITTER = 4;
    private static final double AVG_LITTER = 2.0;
    private static final int INTERBIRTH_DURATION = 365;

    private static int totalLitters = 0;
    private static int totalBorn = 0;

    private int gestationCount;
    private int interbirthCount;
    private Animal[] litter;
    private boolean pregnant = false;
    
    /**
     * Default constructor for FPolarBear
     * Initializes the FPolarBear object with default values.
     */
    public FPolarBear()
    {
        super();
        interbirthCount = 0;
    }

    /**
     * Initializes an FPolarBear with an age input
     * TODO: get rid of
     */
    public FPolarBear(int age)
    {
        super(age);
    }

    /**
     * Returns whether reproduction was successful between two PolarBears.
     * 
     * @return true if the animal successfully reproduces, false otherwise.
     */
    public boolean reproduceWith( Animal male )
    {
        if( !this.isAlive() || !this.isAdult() || this.isPregnant() || interbirthCount < INTERBIRTH_DURATION )
            return false;
            
        if( male == null || !male.isAlive() || !male.isAdult() || male instanceof Female || !(male instanceof PolarBear) )
            return false;

            pregnant = true;
            gestationCount = 0;
    
        int size = 0;
        if(totalLitters == 0)
            size = (int)((MAX_LITTER + 1) * Math.random());
        else if(1.0 * totalBorn / totalLitters < AVG_LITTER)
            size = (int)((MAX_LITTER - AVG_LITTER) * Math.random() + AVG_LITTER);
        else
            size = (int)(AVG_LITTER * Math.random());
        
        litter = new Animal[size];
        totalLitters++;
        return pregnant;
    }

    /**
     * Returns the litter of animals from reproduction.
     * 
     * @return Animal[] the litter as an Animal[]
     */
    public Animal[] giveBirth()
    {
        if( !isAlive() || !pregnant || gestationCount <= GESTATION_DURATION)
            return null;

        for(int i = 0; i < litter.length; i++)
            if(Math.random() < 0.5)
                litter[i] = new PolarBear();
            else
                litter[i] = new FPolarBear();

        totalBorn += litter.length;
        pregnant = false;
        interbirthCount = 0;

        return litter;
    }

    /**
     * Returns whether the PolarBear isPregnant.
     * 
     * @return true if the animal isPregnant, false otherwise.
     */
    public boolean isPregnant()
    {
        return( pregnant );
    }

    /**
     * Aging method, also increments counts gestationCount/interBirthCount
     */
    public void aging()
    {
        super.aging();

        if(pregnant)
            gestationCount++;
        else
            interbirthCount++;
    }

    /**
     * The String "Pregnant true/false female + the super toString call
     *
     * @return true/false if it is Pregnant, and the animal's toString.
     */
    public String toString()
    {
        return "Pregnant " + pregnant + " female " + super.toString();
    }
}
