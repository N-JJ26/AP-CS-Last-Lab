package src.Plants.Producers;

import src.Plants.Plant;

/**
 * The Arctic Willow plant in the Tundra biome
 *
 * @author Austin Benedicto
 * @version 5/14/2025
 */
public class ArcticWillow extends Plant {
    private static final double GROWTH_RATE = 0.4;
    private static final int INITIAL_MASS = 160;
    private static final double MAX_MASS = 480.0;  //maximum mass of this plant in grams TODO!!!!!!!!!!

    /**
     * Constructs the Arctic Willow with an initial mass of 160 grams
     *  and a growth rate of 0.4
     */
    public ArcticWillow()
    {
        super( INITIAL_MASS, GROWTH_RATE, MAX_MASS );
    }
}
