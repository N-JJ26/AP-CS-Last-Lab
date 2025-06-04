package src.Animal;

/**
 * Eats animals
 *
 * @author Mr. DeGroat, Mr. Bouchard, Austin Benedicto
 * @version 6/2/2025
 */
public interface Carnivore
{
    /**
     * Eats only animals
     *
     * @param a is an Animal that is eaten
     * @return whether this Animal ate the other
     */
    public boolean eat( Animal a );
    
    /**
     * Sets the hunting ability of a Carnivore for an accuracy based on the Animal
     *  for instance a Lynx is between 90% - 99% effective at hunting, so upon construction
     *  of a Lynx, the success of the hunt will be based on this accuracy
     *
     * It should be noted that no hunter is 100% effective
     *
     * @return true if the hunt was successful, false otherwise
     */
    public boolean wasHuntSuccessful();
    
    public boolean isHungry();
}
