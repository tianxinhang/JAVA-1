import java.util.*;
import java.io.*;
/**
 * The class will store an arraylist of all the venues 
 *
 * @author TIANXIN HANG
 * @version 2019.5.30
 */
public class ListOfVenues
{
    private ArrayList<Venue> venues;
    /**
     * Default constructor for objects of class ListOfVenues
     */
    public ListOfVenues()
    {
        venues = new ArrayList<Venue>();
    }

    /**
     * Constructor for objects of class ListOfVenues
     * @param An ArrayList<Venue> to indicate new venues 
     */
    public ListOfVenues(ArrayList<Venue> newVenues)
    {
        venues = newVenues;
    }

    /**
     * This is an accessor method which gets information of all venues
     * @return information of all venues 
     */
    public ArrayList<Venue> getVenues()
    {
        return venues;
    }

    /**
     * This is an accessor method which gets name of ith venue
     * @param An int to indicate index of drivers
     * @return The name of ith venue
     */
    public String getVenueName(int index)
    {
        return venues.get(index).getVenueName();
    }

    /**
     * This is an accessor method which gets number of laps of ith venue
     * @param An int to indicate index of drivers
     * @return number of laps of ith venue
     */
    public int getNoOFlaps(int index)
    {
        return venues.get(index).getNoOFlaps();
    }

    /**
     * This is an accessor method which gets average lapTime of ith venue
     * @param An int to indicate index of drivers
     * @return average lapTime of ith venue
     */
    public int getAverageLapTime(int index)
    {
        return venues.get(index).getAverageLapTime();
    }

    /**
     * This is an accessor method which gets chance of rain of ith venue
     * @param An int to indicate index of drivers
     * @return chance of rain of ith venue
     */
    public double getChanceOfRain(int index)
    {
        return venues.get(index).getChanceOfRain();
    }

    /**
     * This is a method which to read venues file
     */
    public ArrayList<String[]> readingVenuesFiles()
    {
        String filename = "venues.txt";
        ArrayList<String[]> venuesInformation = new ArrayList<String[]>();
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
                    String venueName = parts[0];
                    String noOfLaps = parts[1]; 
                    String averageLapTime = parts[2];
                    String chanceOfRain = parts[3];
                    venuesInformation.add(parts);

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
        return venuesInformation;
    }

    /**
      * This is a mututor method which allocate content of venues file to venues
      */
    public void setVenues() 
    {
        ArrayList<String[]> infoVenues= new ArrayList<String[]>();
        infoVenues = readingVenuesFiles();
        for(int i = 0; i < infoVenues.size(); i++)
        {
            Venue venue = new Venue(infoVenues.get(i)[0],Integer.parseInt(infoVenues.get(i)[1]),
                    Integer.parseInt(infoVenues.get(i)[2]),Double.parseDouble(infoVenues.get(i)[3]));
            venues.add(venue);
        }
    }

}
