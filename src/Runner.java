package src;

import src.Animal.Consumers.ArcticFox;
import src.Plants.Producers.ArcticWillow;

public class Runner {
  public static void main( String[] args ) {
    ArcticWillow plant = new ArcticWillow();
    System.out.println( plant.getTotalMass() );
    for( int i = 0; i < 10; i++ )
      plant.grow();
    System.out.println( plant.getTotalMass() );
    }
}
