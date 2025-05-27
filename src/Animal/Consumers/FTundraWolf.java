package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;

/**
 * FTundraWolf TODO: Fix this java doc
 * 
 * @author Nate Johnson, Austin Benedicto, Avi D.
 * @version 5/22/2025
 */
public class FTundraWolf extends TundraWolf implements Female
{
//TODO: ADD IN CONSTANT FOR MAX LITTER SIZE AND AVG LITTER SIZE
    private static final int GESTATION_DURATION = 0;
    private boolean pregnant;
    private int gestationCount;
    private int totalLitters = 0;
    private static final int MAX_LITTER = 99; //TODO
    private static final int AVG_LITTER = 99; //TODO
    private static final int INTERBIRTH_DURATION = 365;
    private int totalBorn;
    private Animal[] litter;
    private int interbirthCount;

    /**
     * Default constructor for FTundraWolf
     * Initializes the FTundraWolf object with default values.
     */
    public FTundraWolf()
    {
        super();
        interbirthCount = 365; //TODO: Change this to a more realistic value
    }

    /**
     * Initializes an FTundraWolf with an age input
     * TODO: get rid of
     */
    public FTundraWolf(int age)
    {
        super(age);
    }

    /**
     * Returns whether reproduction was successful between two Tundra Wolves.
     * 
     * @return true if the animal successfully reproduces, false otherwise.
     */   
    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || this.isPregnant() || interbirthCount < INTERBIRTH_DURATION)
            return false;


        if(male == null || !male.isAlive() || !male.isAdult() || male instanceof Female || !(male instanceof TundraWolf ))
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
                litter[i] = new TundraWolf();
            else
                litter[i] = new FTundraWolf();

        totalBorn += litter.length;
        pregnant = false;
        interbirthCount = 0;

        return litter;
    }

    /**
     * Returns whether the TundraWolf isPregnant.
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
