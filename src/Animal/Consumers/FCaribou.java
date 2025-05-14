package src.Animal.Consumers;

import src.Animal.*;

public class FCaribou extends Caribou implements Female {
    public FCaribou()
    {
        super();
    }

    public boolean reproduceWith( Animal male )
    {
        return false;
    }

    public Animal[] giveBirth()
    {
        return null;
    }

    public boolean isPregnant()
    {
        return false;
    }
}
