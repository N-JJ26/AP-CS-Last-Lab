package src;

import src.Animal.Consumers.*;
import src.Plants.Producers.*;

public class Runner {
  public static void main( String[] args ) {
    /* DECLARATIONS HERE */
    ArcticWillow plant1 = new ArcticWillow();
    CaribouMoss plant2 = new CaribouMoss();
    ArcticDaisy plant3 = new ArcticDaisy(); 

    /* TEST CODE HERE */
    System.out.println( "Willow: \n" + plant1.getTotalMass() );
    for( int i = 0; i < 10; i++ )
      plant1.grow();
    System.out.println( plant1.getTotalMass() );

    System.out.println( "Moss: \n" + plant2.getTotalMass() );
    for( int i = 0; i < 10; i++ )
      plant2.grow();
    System.out.println( plant2.getTotalMass() );

    System.out.println( "Daisy: \n" + plant3.getTotalMass() );
    for( int i = 0; i < 10; i++ )
      plant3.grow();
    System.out.println( plant3.getTotalMass() );
    }
}
