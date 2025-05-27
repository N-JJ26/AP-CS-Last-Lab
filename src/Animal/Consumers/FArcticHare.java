package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;
/**
 * FArcticHare
 * 
 * @author Nate Johnson, Austin Benedicto, Avi D.
 * @version 5/27/2025
 */
public class FArcticHare extends ArcticHare implements Female
{
    private static int totalLitters = 0;
    private static final int GESTATION_DURATION = 26;
    private static final int MAX_LITTER = 1; // TODO
    private static final double AVG_LITTER = 1.0; // TODO
    private static final int INTERBIRTH_DURATION = 365;
    private int gestationCount;
    private Animal[] litter;
    private int totalBorn;
    private boolean pregnant = false;
    private int interbirthCount;


    
    
    /**
     * Default constructor for FArcticHare
     * Initializes the FArcticHare object with default values.
     */
    public FArcticHare()
    {
        super();
        interbirthCount = 365;
    }

    /**
     * Initializes an FArcticHare with an age input
     * TODO: get rid of
     */
    public FArcticHare(int age)
    {
        super(age);
    }

    /**
     * Returns whether reproduction was successful between two ArcticHares.
     * 
     * @return true if the animal successfully reproduces, false otherwise.
     */
    public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || this.isPregnant() || interbirthCount < INTERBIRTH_DURATION)
            return false;
        

        if( male == null || !male.isAlive() || !male.isAdult() || male instanceof Female || !(male instanceof ArcticHare))
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
     * Simulates an ArcticHare giving birth to an Animal[] litter.
     * 
     * @return Animal[] litter of ArcticHares as an Animal[].
     */
    public Animal[] giveBirth()
    {
        if(!isAlive() || !pregnant || gestationCount <= GESTATION_DURATION){
            System.out.println( "worked!" );
            return null;
        }
        for(int i = 0; i < litter.length; i++)
            if(Math.random() < 0.5)
                litter[i] = new ArcticHare();
            else
                litter[i] = new FArcticHare();

        totalBorn += litter.length;
        pregnant = false;
        interbirthCount = 0;

        return litter;
    }

    /**
     * Returns whether the ArcticHare isPregnant.
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

