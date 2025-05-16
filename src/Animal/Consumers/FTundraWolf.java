package src.Animal.Consumers;

import src.Animal.Animal;
import src.Animal.Female;

public class FTundraWolf extends TundraWolf implements Female
{

    public FTundraWolf()
    {
        super();
    }
    
   public boolean reproduceWith( Animal male )
    {
        if(!this.isAlive() || !this.isAdult() || !this.isPregnant())
            return false;


        if(male == null || !male.isAlive() || male.isAlive() || male instanceof Female || !(male instanceof Caribou))
            return false;

        return false;
    }

    @Override
    public Animal[] giveBirth() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'giveBirth'");
    }

    @Override
    public boolean isPregnant() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPregnant'");
    }
    
}
