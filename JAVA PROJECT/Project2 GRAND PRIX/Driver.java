/**
 * The class will hold the information of driver attributes
 *
 * @author TIANXIN HANG
 * @version 2019.5.30
 */
public class Driver
{
    private String name;
    private int ranking;
    private String specialSkill;
    private boolean eligibleToRace;
    private int accumulatedScore;
    private int accumulatedTime;
    private String tyresType;
    
    /**
     * Default constructor for objects of class Drivers
     */
    public Driver()
    {
        name = "";
        ranking = 0;
        specialSkill = "";
        eligibleToRace = true;
        accumulatedScore = 0;
        accumulatedTime = 0;
        tyresType = "dryTyres";
    }

    /**
     * Constructor for objects of class Drivers
     * @param A String to indicate new name of driver
     * @param An int to indicate new rank of driver
     * @param A String to indicate new special skill of driver
     * @param A boolean to indicate new eligible to race of driver
     * @param An int to indicate new accumulated score of driver
     * @param An int to indicate new accumulated time of driver
     * @param A String to indicate new tyre type of driver
     */
    public Driver(String newName,int newRanking,String newSpecialSkill,boolean newEligibleToRace,
    int newAccumulatedScore,int newAccumulatedTime,String newTyresType)
    {
        name = newName;
        ranking = newRanking;
        specialSkill = newSpecialSkill;
        eligibleToRace = newEligibleToRace;
        accumulatedScore = newAccumulatedScore;
        accumulatedTime = newAccumulatedTime;
        tyresType = newTyresType;
    }

    /**
     * This is an accessor method which gets name of driver
     * @return name of driver
     */
    public String getDriverName()
    {
        return name;
    }

    /**
     * This is an accessor method which gets rank of driver
     * @return rank of driver
     */
    public int getRanking()
    {
        return ranking;
    }

    /**
     * This is an accessor method which gets special skill of driver
     * @return special skill of driver
     */
    public String getSpecialSkill()
    {
        return specialSkill;
    }

    /**
     * This is an accessor method which gets eligible to race of driver
     * @return eligible to race of driver
     */
    public boolean getEligibleToRace()
    {
        return eligibleToRace;
    }

    /**
     * This is an accessor method which gets accumulated score of driver
     * @return accumulated score of driver
     */
    public int getAccumulatedScore()
    {
        return accumulatedScore;
    }

    /**
     * This is an accessor method which gets accumulated time of driver
     * @return accumulated time of driver
     */
    public int getAccumulatedTime()
    {
        return accumulatedTime;
    }
    
    /**
     * This is an accessor method which gets tyre type of driver
     * @return tyre type of driver
     */
    public String getTyresType()
    {
        return tyresType;
    }

    /**
     * This is a mututor method which changes name of driver
     * @param A String to indicate new name of driver
     */
    public void setDriverName(String newName)
    {
        name = newName;
    }

    /**
     * This is a mututor method which changes rank of driver
     * @param An int to indicate new rank of driver
     */
    public void setRanking(int newRanking)
    {
        ranking = newRanking;
    }

    /**
     * This is a mututor method which changes special skill of driver
     * @param A String to indicate new special skill of driver
     */
    public void setSpecialSkill(String newSpecialSkill)
    {
        specialSkill = newSpecialSkill;
    }

    /**
     * This is a mututor method which changes eligible to race of driver
     * @param A boolean to indicate new eligible to race of driver
     */
    public void setEligibleToRace(boolean newEligibleToRace)
    {
        eligibleToRace = newEligibleToRace;
    }

    /**
     * This is a mututor method which changes accumulated score of driver
     * @param An int to indicate new accumulated score of driver
     */
    public void setAccumulatedScore(int newAccumulatedScore)
    {
        int temp = getAccumulatedScore();
        accumulatedScore = temp + newAccumulatedScore;
    }

    /**
     * This is a mututor method which changes accumulated time of driver
     * @param An int to indicate new accumulated time of driver
     */
    public void setAccumulatedTime(int newAccumulatedTime)
    {
        int temp = getAccumulatedTime();
        accumulatedTime = temp + newAccumulatedTime;
    }
    
    /**
     * This is a mututor method which changes special tyre type of driver
     * @param A String to indicate new tyre type of driver
     */
    public void setTyresType(String newTyresType)
    {
        tyresType = newTyresType;
    }

    /**
     * This is a mututor method which reset accumulated time of driver to zero
     */
    public void reSetAccumulatedTime()
    {
        accumulatedTime = 0;
    }

    /**
     * This is a mututor method which reset eligible to race of driver to true
     */
    public void reSetEligibleToRace()
    {
        eligibleToRace = true;
    }

}
