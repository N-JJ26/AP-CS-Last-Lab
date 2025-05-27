package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;

/**
 * FArcticFox
 * 
 * @author Nate Johnson, Austin Benedicto, Avi D.
 * @version 5/22/2025
 */
public class FArcticFox extends ArcticFox implements Female
{
    private static final int GESTATION_DURATION = 57;
    private static final int MAX_LITTER = 25;
    private static final double AVG_LITTER = 2.8;
    private static final int INTERBIRTH_DURATION = 27;

    private static int totalBorn = 0;
    private static int totalLitters = 0;

    private boolean pregnant;
    private int gestationCount;
    private int interbirthCount;
    private Animal[] litter;

    /**
     * Default constructor for FArcticFox
     * Initializes the FArcticFox object with default values.
     */
    public FArcticFox()
    {
        super();

        pregnant = false;
        gestationCount = 0;
    }

    /**
     * Initializes an FArcticFox with an age input
     */
    public FArcticFox(int age)
    {
        super(age);
    }

    /**
     * Returns whether reproduction was successful between two ArcticFoxes.
     * 
     * @return true if the animal successfully reproduces, false otherwise.
     */
    public boolean reproduceWith( Animal male )
    {
        if( !this.isAlive() || !this.isAdult() || this.isPregnant())
            return false;

        if(male == null || !male.isAlive()  || !male.isAdult() || male instanceof Female || !(male instanceof ArcticFox))
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
        if( !isAlive() || !pregnant || gestationCount <= GESTATION_DURATION )
            return null;

        for(int i = 0; i < litter.length; i++)
        {
            if(Math.random() < 0.5)
                litter[i] = new ArcticFox();
            else
                litter[i] = new FArcticFox();
        }

        totalBorn += litter.length;
        pregnant = false;
        interbirthCount = 0;

        return litter;
    }

    /**
     * Returns whether the ArcticFox isPregnant.
     * 
     * @return true if the animal isPregnant, false otherwise.
     */
    public boolean isPregnant()
    {
        return pregnant;
    }

    public void aging()
    {
        super.aging();

        if(pregnant)
        {
            gestationCount++;
            interbirthCount++;
        }
    }
}
