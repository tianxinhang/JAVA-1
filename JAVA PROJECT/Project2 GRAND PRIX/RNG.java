import java.util.*;
/**
 * Write a description of class RNG here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RNG
{
    private int minimumValue;
    private int maximumValue;

    /**
     * Default constructor for objects of class RNG
     */
    public RNG()
    {
        minimumValue = 0;
        maximumValue = 0;
    }
    
    /**
     * Constructor for objects of class RNG
     */
    public RNG(int newMinimumValue,int newMaximumValue)
    {
        minimumValue = newMinimumValue;
        maximumValue = newMaximumValue;
    }
    
    /**
     * This is an accessor method which gets minimum value
     * @return minimum value
     */
    public int getMinimumValue()
    {
        return minimumValue;
    }
    
    /**
     * This is an accessor method which gets maximum value
     * @return maximum value
     */
    public int getMaximumValue()
    {
        return maximumValue;
    }
    
    /**
     * This is a mututor method which changes minimum value
     * @param An int to indicate minimun value
     */
    public void setMinimumValue(int newMinimumValue)
    {
        minimumValue = newMinimumValue;
    }
    
    /**
     * This is a mututor method which changes maximum value
     * @param An int to indicate maximum value
     */
    public void setMaximumValue(int newMaximumValue)
    {
        maximumValue = newMaximumValue;
    }
    
     /**
     * This is a method which generate a random number from minimum to maximum value
     * @return The number generated randomly
     */
    public int getRNG(int newMinimumValue,int newMaximumValue)
    {
        Random random = new Random();
        int temp = random.nextInt(newMaximumValue - newMinimumValue + 1) + newMinimumValue;         
        return temp;
    }

    
}
