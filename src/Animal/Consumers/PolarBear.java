package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;

/**
 * PolarBear class represents a carnivorous animal that can be found in the Arctic region.
 * It extends the Animal class and implements the Carnivore interface.
 * 
 * @author Austin Benedicto
 * @version 5/14/2025
 */

 //TODO: ADD IN JAVA DOCS AND SOME OTHER STUFF
public class PolarBear extends Animal implements Carnivore
{
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0; // in years
    private static final int GRAMS_PER_DAY = 5000;
    private static final double HUNTING_EFFICIENCY = 0.6;

    public PolarBear()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN);
    }

    /**
     * Returns whether or not the hunt was successful,
     *  based of a chance between 60 and 73 percent
     */
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
