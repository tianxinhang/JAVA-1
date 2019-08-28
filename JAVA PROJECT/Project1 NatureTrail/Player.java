import java.util.*;
/**
 * The class will specify the attributes and behaviours of a player.
 *
 * @author TIANXIN HANG
 * @version 2019.04.18
 */
public class Player
{
    private String name;
    private int position;
    private int score;
    /**
     * Default constructor for objects of class Player
     */
    public Player()
    {
        name = "";
        position = 0;
        score = 0;
    }

    /**
     * Constructor for objects of class Player
     */
    public Player(String newName,int newPosition,int newScore)
    {
        name = newName;
        position = newPosition;
        score = newScore;
    }

    /**
     * This is an accessor method which gets name of player
     * @return The name of player
     */
    public String getPlayerName()
    {
        return name;
    }

    /**
     * This is a mututor method which changes name of player
     * @param A String to indicate new name of player
     */
    public void setPlayerName(String newName)
    {
        name = newName;
    }

    /**
     * This is an accessor method which gets position of player
     * @return The positon of player
     */
    public int getPosition()
    {
        return position;
    }

    /**
     * This is a mututor method which changes positon of player
     * @param An int to indicate new position of player
     */
    public void setPosition(int newPosition)
    {
        position = newPosition;
    }

    /**
     * This is an accessor method which gets score of player
     * @return The score of player
     */
    public int getScore()
    {
        return score;
    }

    /**
     * This is a mututor method which changes score of player
     * @param An int to indicate new score of player
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }

}
