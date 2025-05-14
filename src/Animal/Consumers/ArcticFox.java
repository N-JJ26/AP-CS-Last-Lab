package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;
import src.Animal.Herbivore;
import src.Plants.*;

/**
 * The Arctic Fox in the Tundra biome
 *
 * @author Nate Johnson
 * @version 5/14/2025
 */
public class ArcticFox extends Animal implements Carnivore, Herbivore {
    /*TODO:
     * finish up code
     */

    private static final double HUNTING_EFFICIENCY = 0.6;

    public ArcticFox()
    {
        super( 50 + ( int )( Math.random() * 7 ), 5200,
                 14 + ( int )( Math.random() * 11 ), 304, 16.3 );
    }

    public boolean isHungry()
    {
        return false;
    }

    public void eat( Animal a )
    {
        return;
    }

    public void eat( Plant p )
    {
        return;
    }

    /**
     * Returns whether or not the hunt was successful,
     *  based of a chance between 60 and 73 percent
     */
    public boolean wasHuntSuccessful()
    {
        return Math.random() < HUNTING_EFFICIENCY + Math.random() * 0.14;
    }

    /**
     * Returns "Arctic Fox" + Animals toString() which gives the age and whether or not
     *  this ArcticFox is alive
     *
     * @return "Arctic Fox" + Animal.toString()
     */
    public String toString()
    {
        return "Arctic Fox" + super.toString();
    }
}
