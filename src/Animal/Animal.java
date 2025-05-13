package src.Animal;

public abstract class Animal
{
    /** the percent chance of living to the adulthood as 15% */
    public static final double ADULT_CHANCE = 0.15;
    /** number of days in a non-leapyear */
    public static final int DAYS_PER_YEAR = 365;
    /** the 10% rule as an approximation for mass conversion, estimated from energy */
    public static final double TROPHIC_EFFICIENCY_RULE = 0.1;

    public Animal( int bodyMassNewborn, int bodyMassAdult, int weaningAge,
                    int onsetFertilityMale, double maxLifeSpan )
    {

    }

    public void aging()
    {
        return;
    }

    public void died()
    {
        return;
    }

    public int getAge()
    {
        return -1;
    }

    public static int getAliveTotal()
    {
        return -1;
    }

    public int getCarcass()
    {
        return -1;
    }

    public static int getTotal()
    {
        return -1;
    }

    public boolean isAdult()
    {
        return false;
    }

    public boolean isAlive()
    {
        return false;
    }

    public abstract boolean isHungry();

    public double massPerDay()
    {
        return Double.NaN;
    }

    public String toString()
    {
        return "!";
    }
}
