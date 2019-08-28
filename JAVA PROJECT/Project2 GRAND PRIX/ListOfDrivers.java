import java.util.*;
import java.io.*;
/**
 * The class will store an arraylist of all the drivers 
 *
 * @author TIANXIN HANG
 * @version 2019.5.30
 */
public class ListOfDrivers
{
    // instance variables - replace the example below with your own
    private ArrayList<Driver> drivers;

    /**
     * Default constructor for objects of class ListOfDrivers
     */
    public ListOfDrivers()
    {
        drivers = new ArrayList<Driver>();
    }

    /**
     * Constructor for objects of class ListOfDrivers
     * @param An ArrayList<Driver> to indicate new drivers
     */
    public ListOfDrivers(ArrayList<Driver> newDrivers)
    {
        drivers = newDrivers;
    }

    /**
     * This is an accessor method which gets information of all drivers
     * @return information of all drivers 
     */
    public ArrayList<Driver> getDrivers()
    {
        return drivers;
    }

    /**
     * This is an accessor method which gets name of ith driver
     * @param An int to indicate index of drivers
     * @return The name of ith driver
     */
    public String getDriversName(int index)
    {
        return drivers.get(index).getDriverName();
    }

    /**
     * This is an accessor method which gets rank of ith driver
     * @param An int to indicate index of drivers
     * @return The rank of ith driver
     */
    public int getRanking(int index)
    {
        return drivers.get(index).getRanking();
    }

    /**
     * This is an accessor method which gets special skill of ith driver
     * @param An int to indicate index of drivers
     * @return The special skill of ith driver
     */
    public String getSpecialSkill(int index)
    {
        return drivers.get(index).getSpecialSkill();
    }

    /**
     * This is an accessor method which gets eligible to race of ith driver
     * @param An int to indicate index of drivers
     * @return The special skill of ith driver
     */
    public boolean getEligibleToRace(int index)
    {
        return drivers.get(index).getEligibleToRace();
    }

    /**
     * This is an accessor method which gets accumulated score of ith driver
     * @param An int to indicate index of drivers
     * @return The accumulated score of ith driver
     */
    public int getAccumulatedScore(int index)
    {
        return drivers.get(index).getAccumulatedScore();
    }

    /**
     * This is an accessor method which gets accumulated time of ith driver
     * @param An int to indicate index of drivers
     * @return The accumulated time of ith driver
     */
    public int getAccumulatedTime(int index)
    {
        return drivers.get(index).getAccumulatedTime();
    }
    
    /**
     * This is an accessor method which gets tyres type of ith driver
     * @param An int to indicate index of drivers
     * @return The tyres type of ith driver
     */
    public String getTyresType(int index)
    {
        return drivers.get(index).getTyresType();
    }

    /**
     * This is a mututor method which changes accumulated score of ith driver
     * @param An int to indicate index of drivers 
     * @param An int to indicate accumulated score 
     */
    public void setAccumulatedScore(int index,int newAccumulatedScore)
    {
        drivers.get(index).setAccumulatedScore(newAccumulatedScore);
    }

    /**
     * This is a mututor method which changes accumulated time of ith driver
     * @param An int to indicate index of drivers 
     * @param An int to indicate accumulated time 
     */
    public void setAccumulatedTime(int index,int newAccumulatedTime)
    {
        drivers.get(index).setAccumulatedTime(newAccumulatedTime);
    }

    /**
     * This is a mututor method which reset accumulated time of all drivers to zero
     */
    public void reSetAccumulatedTime()
    {
        for(int i = 0; i < getDrivers().size(); i++)
        {
            drivers.get(i).reSetAccumulatedTime();
        }
    }

    /**
     * This is a mututor method which changes eligible to race time of ith driver
     * @param An int to indicate index of drivers 
     * @param An int to indicate eligible to race
     */
    public void setEligibleToRace(int index,boolean newEligibleToRace)
    {
        drivers.get(index).setEligibleToRace(newEligibleToRace);
    }
    
    /**
      * This is a mututor method which reset eligible to race of all drivers to true
     */
    public void reSetEligibleToRace()
    {
        for(int i = 0; i < getDrivers().size(); i++)
        {
            drivers.get(i).reSetEligibleToRace();
        }
    }
    
    /**
     * This is a mututor method which changes tyre type of ith driver
     * @param An int to indicate index of drivers 
     * @param An int to indicate tyre type
     */
    public void setTyresType(int index,String newTyresType)
    {
        drivers.get(index).setTyresType(newTyresType);
    }

    /**
     * This is a method which to read drivers file
     */
    public ArrayList<String[]> readingDriversFiles()
    {
        String filename = "drivers.txt";
        ArrayList<String[]> driversInformation = new ArrayList<String[]>();
        int number = 0;
        try
        {
            FileReader inputFile = new FileReader(filename);
            try
            {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine())
                {
                    String inputString = parser.nextLine();
                    String[] parts = inputString.split(",");
                    String driversName = parts[0];
                    String ranking = parts[1]; 
                    String specialSkills = parts[2];
                    driversInformation.add(parts);
                    number++;
                }
            }
            finally
            {
                try
                {
                    inputFile.close();
                }
                catch(Exception e)
                {
                    System.out.println("This file is unable to close");
                }
            }
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(filename + "not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs");
        }
        return driversInformation;
    }

    /**
      * This is a mututor method which allocate content of drivers file to drivers
     */
    public void setDrivers() 
    {
        ArrayList<String[]> infoDrivers= new ArrayList<String[]>();
        infoDrivers = readingDriversFiles();
        for(int i = 0; i < infoDrivers.size(); i++)
        {
            Driver driver= new Driver(infoDrivers.get(i)[0],Integer.parseInt(infoDrivers.get(i)[1]),
            infoDrivers.get(i)[2],true,0,0,"dryTyres");
            drivers.add(driver);
        }
    }
}
