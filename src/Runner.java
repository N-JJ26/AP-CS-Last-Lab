package src;

import src.Animal.Consumers.*;
import src.Plants.Producers.*;

public class Runner {
  public static void main( String[] args ) {
    /* DECLARATIONS HERE */
    Caribou car  = new Caribou( 1000 );
    FCaribou far  = new FCaribou();
    CaribouMoss moss = new CaribouMoss();
    

    /* TEST CODE HERE */
    
    System.out.println( car.isHungry() );
    car.eat(moss);
    System.out.println( car.isHungry() );
    

    }
}
