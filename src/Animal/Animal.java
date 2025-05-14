package src.Animal;

/**
 * abstract Animal keeps track of all Animal objects and aging
 *
 * @author Nate Johnson, Austin Benedicto
 * @version 5/14/2025
 */
public abstract class Animal
{
    /*TODO:
     * fix getCarcass()
     */

    /** the percent chance of living to the adulthood as 15% */
    public static final double ADULT_CHANCE = 0.15;
    /** number of days in a non-leapyear */
    public static final int DAYS_PER_YEAR = 365;
    /** the 10% rule as an approximation for mass conversion, estimated from energy */
    public static final double TROPHIC_EFFICIENCY_RULE = 0.1;

    private int age;
    private boolean isAlive;

    private int bodyMassNewBorn;
    private int bodyMassAdult;
    private int weaningAge;
    private int onsetFertilityMale;
    private double maxLifeSpan;

    private static int totalAnimals;
    private static int totalAliveAnimals;

    /**
     * Constructs an Animal object, incrementing the total number of Animals and total live Animals;
     *  sets the maximum life span of an Animal as well as body masses
     *
     * @param bodyMassNewborn mass of newborn in grams
     * @param bodyMassAdult mass of full grown adult in grams
     * @param weaningAge age in days when the Animal eats in the Simulation
     * @param onsetFertilityMale age in days when the Animal reaches adulthood and can reproduce
     * @param maxLifeSpan the maximum life span in years
     */
    public Animal( int bodyMassNewborn, int bodyMassAdult, int weaningAge,
                    int onsetFertilityMale, double maxLifeSpan )
    {
        this.bodyMassNewBorn = bodyMassNewborn;
        this.bodyMassAdult = bodyMassAdult;
        this.weaningAge = weaningAge;
        this.onsetFertilityMale = onsetFertilityMale;
        this.maxLifeSpan = maxLifeSpan;

        age = 0;
        isAlive = true;

        totalAnimals++;
        totalAliveAnimals++;
    }

    /**
     * Ages the Animal by one day
     */
    public void aging()
    {
        age++;
    }

    /**
     * Sets alive to false and decrements the total number of alive Animals
     */
    public void died()
    {
        isAlive = false;
        totalAliveAnimals--;
    }

    /**
     * Returns the age of the Animal if it is alive
     *
     * @return the age of the Animal, or -1 if it is not alive
     */
    public int getAge()
    {
        return isAlive ? age : -1;
    }

    /**
     * Returns the total number of Animals that are currently alive
     *
     * @return the current total number of alive Animals
     */
    public static int getAliveTotal()
    {
        return totalAliveAnimals;
    }

    /**
     * Calculates (at a rate of 50%) and returns the consumable mass of the Animal as an approximate function
     *  of age (newborn through maturity) killing the Animal
     *
     * @return the mass of the Animal carcass
     */
    public int getCarcass()
    {
        if(isAdult())
            return bodyMassAdult / 2;

        return (( bodyMassAdult - bodyMassNewBorn ) / age) / 2;
    }

    /**
     * Returns the total number of Animals that have been contructed in the Simulation
     *
     * @return the total Animals constructed
     */
    public static int getTotal()
    {
        return totalAnimals;
    }

    /**
     * Determines if the Animal is old enough to reproduce by comparing this age
     *  to the onse of male fertility
     *
     * @return true if the Animal is old enough to reproduce, false otherwise
     */
    public boolean isAdult()
    {
        return age >= onsetFertilityMale;
    }

    /**
     * Returns if the Animal is currently alive
     *
     * @return true if the Animal is currently alive, false otherwise
     */
    public boolean isAlive()
    {
        return isAlive;
    }

    /**
     * Returns if the Animal is hungry or not, to determine if it should eat or continue eating
     *
     * @return true if the Animal is hungry, false otherwise
     */
    public abstract boolean isHungry();

    /**
     * Calculates the number of grams per day the Animal needs to consume
     *  as a function of the change in body mass from newborn to adult over the timeframe to adulthood
     *
     * @return the number of grams per day the Animal needs to consume
     */
    public double massPerDay()
    {
        return ( bodyMassAdult - bodyMassNewBorn ) / onsetFertilityMale;
    }

    /**
     * The String " is x days old, and is alive: true/false."
     *
     * @return the age and alive of the Animal
     */
    public String toString()
    {
        return "is " + age + " days old, and is alive: " + isAlive;
    }
}
