package src.Plants.Producers;

import src.Plants.Plant;

/**
 * The Arctic Willow plant in the Tundra biome
 *
 * @author Austin Benedicto
 * @version 5/14/2025
 */
public class ArcticWillow extends Plant {
    private static final double INITIAL_MASS = 1.5;
    private static final double GROWTH_RATE = 25.0;
    private static final int POPULATION_DENSITY = 100000;

    /**
     * Constructs the ArcticWillow with an initial mass of 1.5 grams
     *  and a growth rate of 25mg/g/day.
     */
    public ArcticWillow(int acres)
    {
        super( (int)(acres * INITIAL_MASS * POPULATION_DENSITY), GROWTH_RATE );
    }
}
