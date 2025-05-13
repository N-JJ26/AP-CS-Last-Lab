package src.Animal;

import src.Plants.*;

/**
 * Eats plants
 *
 * @author Mr. DeGroat and Mr. Bouchard
 * @version November 7, 2018
 */
public interface Herbivore
{
    /**
     * Eats only plants
     * 
     * @param p is a Plant that is eaten
     */
    public void eat( Plant p );
}

