package src.Animal.Consumers;

import src.Animal.*;

/**
 * Female Caribou
 *
 * @author Nate Johnson, Austin Benedicto
 * @version 5/20/2025
 */
public class FCaribou extends Caribou implements Female
{
    private static int totalLitters = 0;
    private static final int GESTATION_DURATION = 228;
    private static final int MAX_LITTER = 1;
    private static final double AVG_LITTER = 1.0;
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

    public FCaribou(int age)
    {
        super(age);
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

        if(male == null || !male.isAlive() || male instanceof Female || !(male instanceof Caribou))
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
