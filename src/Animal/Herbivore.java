package src.Animal;

import src.Plants.*;

/**
 * Eats plants
 *
 * @author Mr. DeGroat, Mr. Bouchard, Austin Benedicto
 * @version 6/2/2025
 */
public interface Herbivore
{
    /**
     * Eats only plants
     * 
     * @param p is a Plant that is eaten
     */
    public void eat( Plant p );

    /**
     * Determines if the herbivore can eat a specific plant.
     *
     * @param p is a Plant that is being checked
     * @return true if the herbivore can eat the plant, false otherwise
     */
    public boolean canEat(Plant p);
}

