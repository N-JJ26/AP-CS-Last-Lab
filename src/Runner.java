package src;

import src.Animal.Consumers.*;
import src.Plants.Producers.*;

public class Runner
{
  public static void main( String[] args )
  {
    /* DECLARATIONS HERE */
    Caribou car  = new Caribou( 1000 );
    CaribouMoss moss = new CaribouMoss();
    
    System.out.println(car.isHungry());
    for(int i = 0; i < 15; i++)
    {
      car.aging();
      System.out.println(moss.getTotalMass());
      car.eat(moss);
    }

    System.out.println(car.isAlive());

    }
}
