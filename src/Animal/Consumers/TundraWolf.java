package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;

public class TundraWolf extends Animal implements Carnivore
{
    private static final int BODY_MASS_NEW_BORN = 450;
    private static final int BODY_MASS_ADULT = 26625;
    private static final int ONSET_FERT_MALE = 669;
    private static final double MAX_LIFE_SPAN = 7; // in years

    /**
     * Constructs a TundraWolf object, incrementing the total number of Animals and total live Animals;
     *  sets the maximum life span of an Animal as well as body masses
     */
    public TundraWolf()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, (int)(Math.random()*69) + 40, ONSET_FERT_MALE, MAX_LIFE_SPAN);
    }

    
    public void eat(Animal a)
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eat'");
    }
    
    public boolean wasHuntSuccessful()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'wasHuntSuccessful'");
    }
    
    public boolean isHungry()
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isHungry'");
    }

    
}
