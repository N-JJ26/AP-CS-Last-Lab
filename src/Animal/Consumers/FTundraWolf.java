package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;

public class FTundraWolf extends TundraWolf implements Female
{
//TODO: ADD IN CONSTANT FOR MAX LITTER SIZE AND AVG LITTER SIZE
    private static final int GESTATION_DURATION = 0;
    private boolean pregnant = false;
    private int gestationCount;
    private int totalLitters;
    private static final int MAX_LITTER = 0;
    private static final int AVG_LITTER = 0;
    private int totalBorn;
    private Animal[] litter;
    private int interbirthCount;

    public FTundraWolf()
    {
        super();
    }

   public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;


        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof Caribou))
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

    @Override
    public boolean isPregnant()
    {
        //TODO: is this correct?
        return pregnant;
    }
}
