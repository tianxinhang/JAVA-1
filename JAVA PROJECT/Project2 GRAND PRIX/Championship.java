import java.io.*;
import java.util.*;
/**
 * The class will show the mechanism of how the championship works and start a championship
 *
 * @author TIANXIN HANG
 * @version 2019.05.30
 */
public class Championship
{
    private ListOfDrivers drivers;
    private ListOfVenues venues;
    /**
     * Default constructor for objects of class Championship
     */
    public Championship()
    {
        drivers = new ListOfDrivers();
        venues = new ListOfVenues();
    }

    /**
     * Constructor for objects of class Championship
     * @param A ListOfDrivers to indicate new drivers
     * @param A ListOfVenues to indicate new venues
     */
    public Championship(ListOfDrivers newDrivers,ListOfVenues newVenues)
    {
        drivers = newDrivers;
        venues = newVenues;
    }

    /**
     * This is an accessor method which gets drivers
     * @return a list of drivers
     */
    public ListOfDrivers getDrivers()
    {
        return drivers;
    }

    /**
     * This is an accessor method which gets venues
     * @return a list of venues
     */
    public ListOfVenues getVenues()
    {
        return venues;
    }

    /**
     * This is a mututor method which set the drivers
     * @param A ListOfDrivers to indicate new drivers
     */
    public void setDrivers(ListOfDrivers newDrivers)
    {
        drivers = newDrivers;
    }

    /**
     * This is a mututor method which set the venues
     * @param A ListOfDrivers to indicate new venues
     */
    public void setDrivers(ListOfVenues newVenues)
    {
        venues = newVenues;
    }

    /**
     * This is a method to display welcome message
     */
    public void welcomeToGame()
    {
        System.out.println('\u000C');  // clear screen
        String position[] = new String[100];
        for(int i = 1;i < 300;i++){
            System.out.print("=");
        }
        System.out.println("\r");
        for(int i = 1;i < 35;i++){
            System.out.print(" ");
        }
        System.out.println("Welcome to play Grand Prix!");
        System.out.println("\r");
        for(int i = 1;i < 300;i++){
            System.out.print("=");
        }
        System.out.println("\r");
        System.out.println("The game will use venues defined in the venues.txt file.");
        System.out.println("The game will use drivers defined in the drivers.txt file.");
    }

    /**
     * This is an accessor method which gets how many races will be run in championship
     * @return the number of races will be run in championship
     */
    public int getNumberOfRace()
    {
        System.out.println("please enter the number of races in the championship (3 to 5)");
        int temp = validation(3,5);
        System.out.println("The number of race: " + temp);
        return temp;
    }

    /**
     * This is an accessor method which will ask to input a number and gets the number if it can pass the validation
     * @param An int to indicate minimum number of boundary
     * @param An int to indicate maximum number of boundary
     * @return the input number
     */
    public int validation(int min,int max)
    {   
        boolean a = true;
        String temp1 = "";
        int temp2 = 0;
        do
        {            
            Scanner console = new Scanner(System.in);
            temp1 = console.nextLine();  
            if (temp1.length() == 0)
            {
                System.out.println("Error! input can not be empty");
                a = false;
            }
            else
            {
                for(int position = 0; position < temp1.length(); position++)
                {
                    char thisCharacter = temp1.charAt(position);
                    if (thisCharacter < '0' || thisCharacter > '9')
                    {
                        System.out.println("error,only integer should be input");
                        a = false;
                        break;
                    }
                    else 
                        a = true;
                }
                if(a == true)
                {
                    temp2 = Integer.parseInt(temp1);
                    if(temp2 >= min && temp2 <= max)
                    {
                        a = true;
                    }
                    else    
                    {
                        a = false;
                        System.out.println("Length must between " + min + " and " + max);
                    }
                }
            }
        }
        while(a == false);
        return temp2;
    }

    /**
     * This is a mututor method which changes accumulated time of drivers due to their special skills
     * @param An int to indicate ith drivers 
     * @param An int to indicate ith lap
     */
    public void getSkill(int driverNo,int lapNo)
    {
        int reduction = 0;
        RNG rng = new RNG();
        String a = drivers.getSpecialSkill(driverNo);
        if(a.equals("Braking")||a.equals("Cornering"))
            reduction = rng.getRNG(1,8);
        if(a.equals("Overtaking") && lapNo%3 == 0)
            reduction = rng.getRNG(10,20);
        drivers.setAccumulatedTime(driverNo,reduction);
    }

    /**
     * This is a mututor method which changes accumulated time of drivers due to problem they met
     * @param An int to indicate ith drivers 
     */
    public void meetProblem(int driverNo)
    {
        int additionTime = 0;
        RNG rng = new RNG();
        int a = rng.getRNG(1,100);
        if(a == 1)
        {
            additionTime = 0;
            drivers.setEligibleToRace(driverNo,false);
            System.out.println(drivers.getDriversName(driverNo) + ": unrecoverable fault (lost eligiblility of game)");
        }
        if(a > 1 && a < 5)
        {
            additionTime = 120;
            System.out.println(drivers.getDriversName(driverNo) + ": major mechanical fault(lost 120 sec)");
        }
        if(a >= 5 && a <= 9)
        {
            additionTime = 20;
            System.out.println(drivers.getDriversName(driverNo) + ": minor mechanical fault(lost 20 sec)");
        }
        drivers.setAccumulatedTime(driverNo,additionTime);
    }

    /**
     * This is an accessor method which gets rank of driver
     * @param An int to indicate ith venue  
     * @return rain or not
     */
    public boolean chanceOfRain(int venueNo)
    {
        int rainChance = (int)(venues.getChanceOfRain(venueNo) * 100);
        RNG rng = new RNG();
        int rn = rng.getRNG(1,100);
        if(rainChance >= rn)
        {
            System.out.println("Weather: Rainy");
            return true;
        }
        else
        {
            System.out.println("Weather: Good");
            return false;
        }
    }

    /**
     * This is a mututor method which changes tyre type
     * @param An int to indicate ith drivers 
     */
    public void changeTyres(int driverNo)
    {
        RNG rng = new RNG();
        int rn = rng.getRNG(1,2);
        if(rn == 1)
        {
            System.out.println(drivers.getDriversName(driverNo) + "  is to spend 10 seconds to change to wet-tyres");
            drivers.setAccumulatedTime(driverNo,10);
            drivers.setTyresType(driverNo,"wetTyres");

        }
        else
        {
            drivers.setTyresType(driverNo,"dryTyres");
        }
    }

    /**
     * This is a method which runs each lap
     * @param An int to indicate ith venue
     * @param An int to indicate ith driver
     * @param An int to indicate ith lap
     * @param A boolean to indicate rain or not
     */
    public void eachLap(int venueNo,int driverNo,int lapNo,boolean rain)
    {
        int time = 0;
        meetProblem(driverNo); 
        getSkill(driverNo,lapNo);
        drivers.setAccumulatedTime(driverNo,venues.getAverageLapTime(venueNo));
        if((lapNo == 1 || lapNo == 2) && rain == true)
        {
            changeTyres(driverNo);
        }
    }

    /**
     * This is a method which run a one race
     * @param An int to indicate ith venue
     * @param An int to indicate ith lap
     */
    public void takeLap(int venueNo,int lapNo)
    {
        boolean rain = chanceOfRain(venueNo);
        if(rain)
        {
            for(int driverNo = 0; driverNo < drivers.getDrivers().size(); driverNo++)
            {
                if(drivers.getEligibleToRace(driverNo))
                {
                    eachLap(venueNo,driverNo,lapNo,rain);
                    if(drivers.getTyresType(driverNo).equals("dryTyres"))
                    {
                        drivers.setAccumulatedTime(driverNo,5);
                        System.out.println(drivers.getDriversName(driverNo) + " is using dry tyre(lost 5 sec)");
                    }
                }
            }
        }
        else
        {
            for(int driverNo = 0; driverNo < drivers.getDrivers().size(); driverNo++)
            {
                if(drivers.getEligibleToRace(driverNo))
                {
                    eachLap(venueNo,driverNo,lapNo,rain);
                }
            }
        }
    }

    /**
     * This is a method which shows each lap result
     * @param An int to indicate ith venue
     * @param An int to indicate ith lap
     */
    public void eachLapResultDisplay(int venueNo,int lapNo)
    {
        ArrayList<Integer> index = new ArrayList<Integer>();
        ArrayList<Integer> driveTime = new ArrayList<Integer>();
        System.out.println("Lap No: " + (lapNo + 1));
        if(lapNo == 0)
        {
            for(int i = 0; i < drivers.getDrivers().size(); i++)
            {
                drivers.setAccumulatedTime(i,gridPosition(i));
            }
        }
        takeLap(venueNo,lapNo);
        for(int driverNo = 0; driverNo < drivers.getDrivers().size(); driverNo++)
        {
            index.add(driverNo);
            driveTime.add(drivers.getAccumulatedTime(driverNo));
        }
        sortArray(driveTime,index);
        for(int i = 0; i < index.size(); i++)
        {
            if(drivers.getEligibleToRace(index.get(i)) == false)
            {
                index.remove(i);
            }
        }
        for(int i = 1;i < 100;i++){
            System.out.print("=");
        }
        System.out.print("\n");
        int maxLength = 0;
        for(int i = 0; i < drivers.getDrivers().size(); i++)
        {
            if(drivers.getDriversName(i).length() >  maxLength)
            {
                maxLength = drivers.getDriversName(i).length();
            }
        }
        System.out.println("Name"  + " ".repeat(maxLength + 1) + "Time  " + "Rank");
        for(int i = 0; i <  index.size(); i++)
        {
            if(drivers.getAccumulatedTime(index.get(i)) >  99)
            {
                System.out.println(drivers.getDriversName(index.get(i))+ " ".repeat(maxLength - drivers.getDriversName(index.get(i)).length() + 5) 
                    + drivers.getAccumulatedTime(index.get(i)) + " ".repeat(3) + (i + 1));
            }
            else
            {
                System.out.println(drivers.getDriversName(index.get(i))+ " ".repeat(maxLength - drivers.getDriversName(index.get(i)).length() + 5) 
                    + drivers.getAccumulatedTime(index.get(i)) + " ".repeat(4) + (i + 1));
            }

        }
        for(int i = 1;i < 100;i++){
            System.out.print("=");
        }
        System.out.print("\n");
        System.out.println("Leading driver: " + drivers.getDriversName(index.get(0)));
        displayDelay();
    }

    /**
     * This is an accessor method which gets time penalty due to grid position
     * @return penalty time
     */
    public int gridPosition(int driverNo)
    {
        int timePenalty = 0;
        int ranking = drivers.getRanking(driverNo);
        switch(ranking)
        {
            case 0:timePenalty = 0;break;
            case 1:timePenalty = 3;break;
            case 2:timePenalty = 5;break;
            case 3:timePenalty = 7;break;
            default:timePenalty = 10;break;
        }
        return timePenalty;
    }

    /**
     * This is a method which sorts elements of arraylist order by Ascending
     * @param An ArrayList<Integer> to indicate first arraylist
     * @param An ArrayList<Integer> to indicate second arraylist
     */
    public void sortArray(ArrayList<Integer> arr1,ArrayList<Integer> arr2)
    {
        RNG rng = new RNG();
        for(int i = 0;i < arr1.size() - 1; i++)
        {
            for(int j = 0; j < arr1.size() - 1 - i; j++)
            {
                if(arr1.get(j) > arr1.get(j + 1))
                {
                    int temp1 = arr1.get(j);
                    arr1.set(j,arr1.get(j + 1));
                    arr1.set(j + 1,temp1);
                    int temp2 = arr2.get(j) ;
                    arr2.set(j,arr2.get(j + 1));
                    arr2.set(j + 1,temp2);
                }
                if(arr1.get(j)  == arr1.get(j + 1))
                {
                    int RN = rng.getRNG(0,1);
                    if(RN == 0)
                    {
                        int temp1 = arr1.get(j);
                        arr1.set(j,arr1.get(j + 1));
                        arr1.set(j + 1,temp1);
                        int temp2 = arr2.get(j) ;
                        arr2.set(j,arr2.get(j + 1));
                        arr2.set(j + 1,temp2);
                    }
                }
            }
        }
    }

    /**
     * This is a method which shows each race result
     * @param An int to indicate ith venue
     */
    public void resultOfEachRace(int venueNo)
    {
        ArrayList<Integer> index = new ArrayList<Integer>();
        ArrayList<Integer> totalTime = new ArrayList<Integer>();

        for(int i = 0; i < venues.getNoOFlaps(venueNo); i++)
        {
            eachLapResultDisplay(venueNo,i);
            System.out.println("\r");
        }
        for(int i = 0;i < drivers.getDrivers().size(); i++)
        {
            index.add(i);
            totalTime.add(drivers.getAccumulatedTime(i));
        }
        sortArray(totalTime,index);
        int[] points = {8,5,3,1};
        int place = 0;
        for(int i = 0; i < index.size(); i++)
        {
            if(drivers.getEligibleToRace(index.get(i)) == false)
            {
                index.remove(i);
            }
        }
        for(int i = 0; i < index.size() && place < points.length; i++)
        {
            drivers.setAccumulatedScore(index.get(i),points[place]);
            place++;
        }
        System.out.println("The result of this race is :");
        for(int i = 0; i < place; i++)
        {
            System.out.println("Place " + (i + 1) + ": " + drivers.getDriversName(index.get(i)) + " using " + drivers.getAccumulatedTime(index.get(i)) + 
                " seconds and got " + points[i] + " points");
        }
    }

    /**
     * This is a mututor method which set drivers
     */
    public void setDriver()
    {
        drivers.setDrivers();
    }

    /**
     * This is a method which to press enter to continue game
     */
    public void inputEnter()
    {
        Scanner enter = new Scanner(System.in);
        System.out.println("Please press Enter to continue game");
        String enter1 = enter.nextLine(); // press Enter will show nothing on terminal 
    }

    /**
     * This is a method which to display venues in list
     */
    public void displayVenues()
    {
        ListOfVenues newVenues3 = new ListOfVenues();
        newVenues3.setVenues();
        System.out.println("Please select the Venues below ");
        for(int i = 1;i < 100;i++){
            System.out.print("=");
        }
        System.out.print("\n");
        int maxLength = 0;
        for(int i = 0; i < newVenues3.getVenues().size(); i++)
        {
            if(newVenues3.getVenueName(i).length() >  maxLength)
            {
                maxLength = newVenues3.getVenueName(i).length();
            }
        }
        System.out.println("No.   " + "Name of Venues" + " ".repeat(maxLength - 10) + "Laps  " + "AVGTime(sec)");
        for(int i = 0; i < newVenues3.getVenues().size(); i++)
        {
            System.out.println((i + 1) + " ".repeat(5) + newVenues3.getVenueName(i) + " ".repeat(maxLength - newVenues3.getVenueName(i).length() + 5) + 
                newVenues3.getNoOFlaps(i) +  " ".repeat(6) + newVenues3.getAverageLapTime(i));
        }
        for(int i = 1;i < 100;i++){
            System.out.print("=");
        }
        System.out.print("\n");
    }

    /**
     * This is an accessor method which set up venue which will be run in next race
     * @return a integer which indicates the venue chosen
     */
    public int setRaceVenues()
    {
        ListOfVenues newVenues1 = new ListOfVenues();
        newVenues1.setVenues();
        int temp = 0;
        do
        {
            System.out.println("please enter the No. of venue:");
            temp = validation(1,newVenues1.getVenues().size());
            if(newVenues1.getAverageLapTime(temp - 1) > 90 || newVenues1.getAverageLapTime(temp - 1) < 60)
             {
                 System.out.println("The average lap time for venue should range from 60 to 90 seconds");
                 System.out.println("\n");
                }
        }
        while(newVenues1.getAverageLapTime(temp - 1) > 90 || newVenues1.getAverageLapTime(temp - 1) < 60);
        System.out.println("You have select venue: " + newVenues1.getVenueName(temp - 1));
        System.out.println("\r");
        return temp;
    }

    /**
     * This is a method which to avoid the same venue will be used
     */
    public void checkSameVenue()
    {
        ListOfVenues newVenues2 = new ListOfVenues();
        newVenues2.setVenues();
        int index = 0;
        boolean check = true;
        while(check)
        {
            index = setRaceVenues();
            boolean check2 = true;
            if(venues.getVenues().size() == 0)
            {
                venues.getVenues().add(newVenues2.getVenues().get(index - 1));
                check = false;
            }
            else

            {
                for(int j = 0; j < venues.getVenues().size(); j++)
                {
                    if(venues.getVenueName(j).equals(newVenues2.getVenueName(index - 1)))
                    {
                        System.out.println("This venue has been used please select another one.");
                        check2 = false;
                        break;
                    }
                }
                if(check2 == true)
                {
                    venues.getVenues().add(newVenues2.getVenues().get(index - 1));
                    check = false;
                }
            }
        }
    }

    /**
     * This is a method which to delay the display
     */
    public void displayDelay()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * This is a method which to run all races
     */
    public void runAllRaces()
    {
        int numberOfRace = getNumberOfRace();
        for(int i = 0; i < numberOfRace;i++)
        {
            displayVenues();
            checkSameVenue();
            resultOfEachRace(i);   
            System.out.println("\r");
            drivers.reSetEligibleToRace();
            drivers.reSetAccumulatedTime();
            displayDelay();
        }
    }

    /**
     * This is a method which to show result of championship
     */
    public void showResult()
    {
        ArrayList<Integer> index = new ArrayList<Integer>();
        ArrayList<Integer> totalPoints = new ArrayList<Integer>();
        for(int i = 0; i < drivers.getDrivers().size(); i++)
        {
            index.add(i);
            totalPoints.add(drivers.getAccumulatedScore(i));
        }
        sortArray(totalPoints,index);
        for(int i = 1;i < 100;i++){
            System.out.print("=");
        }
        System.out.print("\n");
        int maxLength = 0;
        for(int i = 0; i < drivers.getDrivers().size(); i++)
        {
            if(drivers.getDriversName(i).length() >  maxLength)
            {
                maxLength = drivers.getDriversName(i).length();
            }
        }
        System.out.println("Rank  " + "Name" + " ".repeat(maxLength + 1)  + "Points");
        for(int i = 0; i <  index.size(); i++)
        {
            int reverse = index.size() - i -1;
            System.out.println((i + 1) + " ".repeat(5) + drivers.getDriversName(index.get(reverse)) 
                + " ".repeat(maxLength - drivers.getDriversName(index.get(reverse)).length() + 5) 
                + drivers.getAccumulatedScore(index.get(reverse)));
        }
        for(int i = 1;i < 100;i++){
            System.out.print("=");
        }
    }

    /**
     * This is a method which to save drivers information back to drivers.txt
     */
    public void saveBackDriversInfo()
    {
        ArrayList<String> info = new ArrayList<String>();
        for(int i = 0; i < drivers.getDrivers().size(); i++)
        {
            String input = drivers. getDriversName(i) + "," + drivers.getRanking(i) + "," + drivers.getSpecialSkill(i);
            info.add(input);
        }
        try
        {
            PrintWriter output = new PrintWriter("drivers.txt");
            for (int i = 0; i < info.size(); i++)
            {
                output.println(info.get(i));
            }
            try
            {
                output.close();
            }
            catch (Exception e)
            {
                System.out.println("This file is unable to close");
            }
        }
        catch(IOException e)
        {
            System.out.println("This file is not exist");
        }
    }

    /**
     * This is a method which to start the championship
     */
    public void championshipStarter()
    {
        welcomeToGame();
        setDriver();
        runAllRaces();
        showResult();
        saveBackDriversInfo();
    }
}
