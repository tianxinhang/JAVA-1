
/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car
{
    // instance variables - replace the example below with your own
    private int year;
    private String model;

    /**
     * Constructor for objects of class Car
     */
    public Car()
    {
        // initialise instance variables
        year = 0;
        model = "";
    }

    public int countString()
    {
        String array[] = {"loving","loved","loving"};

        int count = 0;
        for(int i = 0; i < 3; i++)
        {
            if(array[i].substring(array[i].length()-3).equals("ing"))
            {
                count = count + 1;
            }

        }
        return count;
    }

    public Car(int newYear,String newModel)
    {
        year = newYear;
        model = newModel;
    }

    public int getYear()
    {
        return year;
    }

    public String getModel()
    {
        return model;
    }

    public void setYear(int newYear)
    {
        year = newYear;
    }

    public void setModel(String newModel)
    {
        model = newModel;
    }

}
