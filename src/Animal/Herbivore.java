package src.Animal;

import src.Plants.*;

/**
 * Eats plants
 *
 * @author Mr. DeGroat, Mr. Bouchard, Austin Benedicto, Nate Johnson
 * @version 6/4/2025
 */
public interface Herbivore
{
    /**
     * Eats only plants
     * 
     * @param p is a Plant that is eaten
     */
    public boolean eat( Plant p );
}

