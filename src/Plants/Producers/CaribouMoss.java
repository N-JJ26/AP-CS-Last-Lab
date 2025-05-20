package src.Plants.Producers;

import src.Plants.Plant;

/**
 * The Caribou Moss Plant in the Tundra biome
 *
 * @author Nate Johnson
 * @version 5/14/2025
 */
public class CaribouMoss extends Plant {
    private static final int INITIAL_MASS = 9;
    private static final double GROWTH_RATE = 0.02;
    private static final double MAX_MASS = 27.0;  //maximum mass of this plant in grams TODO!!!!!!!!!!

    /**
     * Constructs the CaribouMoss with an initial mass of 9
     *  and a growth rate of 0.02
     */
    public CaribouMoss()
    {
        super( INITIAL_MASS, GROWTH_RATE, MAX_MASS );
    }
}
