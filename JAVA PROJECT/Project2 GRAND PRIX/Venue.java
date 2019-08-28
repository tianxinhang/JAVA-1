/**
 * The class will hold the information of venue attributes
 *
 * @author TIANXIN HANG
 * @version 2019.5.30
 */
public class Venue
{
    private String venueName;
    private int noOfLaps;
    private int averageLapTime;
    private double chanceOfRain;

    /**
     * Default constructor for objects of class Venue
     */
    public Venue()
    {
        // initialise instance variables
        venueName = "";
        noOfLaps = 0;
        averageLapTime = 0;
        chanceOfRain = 0.0;
    }

    /**
     * Constructor for objects of class Venue
     * @param A String to indicate name of venue
     * @param An int to indicate number of lap of venue
     * @param An int to indicate average lapTime of venue
     * @param A double to indicate chance of rain of venue
     */
    public Venue(String newVenueName,int newNoOFlaps,int newAverageLapTime,double newChanceOfRain)
    {
        venueName = newVenueName;
        noOfLaps = newNoOFlaps;
        averageLapTime = newAverageLapTime;
        chanceOfRain = newChanceOfRain;
    }

    /**
     * This is a mututor method which changes name of venue
     * @param A String to indicate name of venue
     */
    public void setVenueName(String newVenueName)
    {
        venueName = newVenueName;
    }

    /**
     * This is a mututor method which changes laps of venue
     * @param An int to indicate laps of venue
     */
    public void setNoOFlaps(int newNoOFlaps)
    {
        noOfLaps = newNoOFlaps;
    }

    /**
     * This is a mututor method which changes average lapTime of venue
     * @param An int to indicate average lapTime of venue
     */
    public void setAverageLapTime(int newAverageLapTime)
    {
        averageLapTime = newAverageLapTime;
    }

    /**
     * This is a mututor method which changes chance of rain of venue
     * @param A double to indicate chance of rain of venue
     */
    public void setChanceOfRain(double newChanceOfRain)
    {
        chanceOfRain = newChanceOfRain;
    }

    /**
     * This is an accessor method which gets name of venue
     * @return name of venue
     */
    public String getVenueName()
    {
        return venueName;
    }
    
    /**
     * This is an accessor method which gets number of lap of venue
     * @return number of lap of venue
     */
    public int getNoOFlaps()
    {
        return noOfLaps;
    }

    /**
     * This is an accessor method which gets average lapTime of venue
     * @return average lapTime of venue
     */
    public int getAverageLapTime()
    {
        return averageLapTime;
    }

    /**
     * This is an accessor method which gets chance of rain of venue
     * @return rain or not
     */
    public double getChanceOfRain()
    {
        return chanceOfRain;
    }
}
