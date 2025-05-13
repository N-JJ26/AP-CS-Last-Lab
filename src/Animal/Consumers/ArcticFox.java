package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Carnivore;
import src.Animal.Herbivore;
import src.Plants.*;

public class ArcticFox extends Animal implements Carnivore, Herbivore {
    /*TODO:
     * finish up code
     */

    public ArcticFox()
    {
        super( 50 + ( int )( Math.random() * 7 ), 5200, 14 + ( int )( Math.random() * 11 ),
                304, 16.3);
    }

    public boolean isHungry()
    {
        return false;
    }

    public void eat( Animal a )
    {

    }

    public void eat( Plant p )
    {
        
    }

    public boolean wasHuntSuccessful()
    {
        return false;
    }
}
