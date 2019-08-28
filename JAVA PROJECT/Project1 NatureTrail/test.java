import java.io.*;
import java.util.*;
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    private String x;

    /**
     * Constructor for objects of class test
     */
    public test()
    {
        // initialise instance variables
        x = "";
    }

    
    public ArrayList<String[]> readFile()
    {
        String fileName = "Students.txt";
        ArrayList<String[]> info = new  ArrayList<String[]>();
        try
        {
             FileReader newFile = new FileReader(fileName);
            
        }
        catch(FileNotFoundException exception)
        {
            System.out.println("file not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O exception occurs");
        }
        return info;
         
    }
}
