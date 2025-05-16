package src;

import src.Plants.Producers.*;
import src.Animal.Consumers.*;
import src.Animal.Animal;


/**
 * Runner class serves as the entry point for the simulation program.
 * 
 * @author Austin Benedicto, Nate Johnson, Avi Dasgupta
 * @version 5/14/2025
 */
public class Runner
{
  Animal[][] animals = new Animal[Integer.MAX_VALUE][Integer.MAX_VALUE];
  public static void main(String[] args) 
  {
    ArcticDaisy daisy = new ArcticDaisy();
    System.out.println( daisy.getTotalMass() );
    daisy.grow();
    System.out.println( daisy.getPercentRemaining() );
    daisy.grow();
    for( int i = 0; i < 9; i++ )
    {
      daisy.grow();
    }
    System.out.println( daisy.getTotalMass() );
  }

}