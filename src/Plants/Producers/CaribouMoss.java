package src.Plants.Producers;

import src.Plants.Plant;

/**
 * The Caribou Moss Plant in the Tundra biome
 *
 * @author Nate Johnson
 * @version 5/14/2025
 */
public class CaribouMoss extends Plant {
    private static final double INITIAL_MASS = 0.2;
    private static final double GROWTH_RATE = 5.0;
    private static final double MAX_MASS = 1.5;  //maximum mass of this plant in grams TODO!!!!!!!!!!

    /**
     * Constructs the CaribouMoss with an initial mass of 0.2g
     *  and a growth rate of 1.0mg/g/day.
     */
    public CaribouMoss()
    {
        super( INITIAL_MASS, GROWTH_RATE, MAX_MASS );
    }
}
