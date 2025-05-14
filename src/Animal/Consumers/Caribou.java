package src.Animal.Consumers;
import src.Animal.Animal;
import src.Animal.Herbivore;
import src.Plants.Plant;

/**
 * Caribou class represents a herbivorous animal that can be found in the Arctic region.
 * It extends the Animal class and implements the Herbivore interface.
 * 
 * @author Austin Benedicto
 * @version 5/14/2025
 */
public class Caribou extends Animal implements Herbivore
{
    private static final int BODY_MASS_NEW_BORN = 6500;
    private static final int BODY_MASS_ADULT = 101250;
    private static final int WEANING_AGE = 120;
    private static final int ONSET_FERT_MALE = 680;
    private static final double MAX_LIFE_SPAN = 14.0; // in years

    public Caribou()
    {
        super(BODY_MASS_NEW_BORN, BODY_MASS_ADULT, WEANING_AGE, ONSET_FERT_MALE, MAX_LIFE_SPAN);
    }

    public void eat(Plant p)
    {
        //TODO: Implement the logic for eating a plant
    }

    public boolean isHungry()
    {
        //TODO: Implement the logic to determine if the Caribou is hungry
        return true;
    }
    
}
