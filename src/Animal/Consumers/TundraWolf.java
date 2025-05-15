package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;

public class TundraWolf extends Animal implements Carnivore
{
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0; // in years

    /**
     * Constructs a TundraWolf object, incrementing the total number of Animals and total live Animals;
     *  sets the maximum life span of an Animal as well as body masses
     */
    public TundraWolf()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN);
    }

    @Override
    public void eat(Animal a) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eat'");
    }
    @Override
    public boolean wasHuntSuccessful() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'wasHuntSuccessful'");
    }
    @Override
    public boolean isHungry() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isHungry'");
    }

    
}
