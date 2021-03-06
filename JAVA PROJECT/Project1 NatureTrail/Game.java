import java.util.*;
/**
 * The class will manage the playing of a game
 *
 * @author TIANXIN HANG
 * @version 2019.04.18
 */
public class Game
{
    private int trailLength;
    private Trail natureTrail;
    private Player playerOne;
    private Player playerTwo;

    /**
     * Default constructor for objects of class Game
     */
    public Game()
    {
        trailLength = 0;
        natureTrail = new Trail();
        playerOne = new Player();
        playerTwo = new Player(); //Player() is class Player constructor

    }

    /**
     * Constructor for objects of class Game
     */
    public Game(int newTrailLength,Trail newNatureTrail,Player newPlayerOne,Player newPlayerTwo)

    {
        trailLength = newTrailLength;
        natureTrail = newNatureTrail;
        playerOne = newPlayerOne;
        playerTwo = newPlayerTwo;
    }

    /**
     * This is an accessor method which gets trailLength
     * @return The trailLength
     */
    public int getTrailLength()
    {
        return trailLength;
    }

    /**
     * This is an accessor method which gets natureTrail
     * @return The natureTrail
     */
    public Trail getNatureTrail()
    {
        return natureTrail;
    }

    /**
     * This is an accessor method which gets playerOne
     * @return The playerOne
     */
    public Player getPlayerOne()
    {
        return playerOne;
    }

    /**
     * This is an accessor method which gets playerTwo
     * @return The playerTwo
     */
    public Player getPlayerTwo()
    {
        return playerTwo;
    }

    /**
     * This is a mututor method which changes name of playerOne
     */
    public void setPlayerOne()
    {
        System.out.println("Please enter your name");
        System.out.println("Name must be between 1 and 6 characters");
        Scanner console = new Scanner(System.in);
        String newName = console.nextLine();
        if(newName.length() < 1 || newName.length() > 6 )
        {
            System.out.println("Name must be between 1 and 6 characters") ;
            setPlayerOne();
        }
        else
        if(newName.charAt(0) == ' ' || newName.charAt(newName.length()-1) ==' ')
        {
            System.out.println("Name is not begin or end with a space character ") ;
            setPlayerOne();
        }
        else{
            playerOne.setPlayerName(newName);
            System.out.println("PlayerOne is " + playerOne.getPlayerName());
        }
    }

    /**
     * This is a mututor method which changes name of playerTwo
     */
    public void setPlayerTwo()
    {
        playerTwo.setPlayerName("Computer");
        System.out.println("playerTwo is " + playerTwo.getPlayerName());
    }

    /**
     * This is a mututor method which changes trail length
     */
    public void setTrailLength()
    {   
        boolean a = true;
        String temp = "";
        do
        {
            System.out.println("Please set trail length(10 to 20)");
            Scanner console = new Scanner(System.in);
            temp = console.nextLine();  
            if (temp.length() == 0)
            {
                System.out.println("Error! input can not be empty");
                a = false;
            }
            else
            {
                for(int position = 0; position < temp.length(); position++)
                {
                    char thisCharacter = temp.charAt(position);
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
                    int length = Integer.parseInt(temp);
                    if(length >= 10 && length <= 20)
                    {
                        trailLength = length;
                        a = true;
                    }
                    else    
                    {
                        a = false;
                        System.out.println("Length must between 10 and 20");
                    }
                }
            }
        }
        while(a == false);
        System.out.println("The trail length is: " + trailLength);
    }

    /**
     * This is a method which say welcome in terminal
     */
    public void welcomeToGame()
    {
        System.out.println('\u000C');  // clear screen
        System.out.println("Welcome to play Nature Trail Game!");
    }

    /**
     * This is a method which show live position in terminal
     */
    public void displayPosition()
    {
        String position[] = new String[trailLength];
        for(int i = 1;i < trailLength - 1;i++){
            position[i] = " _   ";
        }
        position[0] = "S   ";
        position[trailLength - 1] = " F";
        for(int i = 0;i < 4;i++)
        {
            position[natureTrail.getFeaturePosition(i)] =" " + natureTrail.getFeatureType(i).substring(0,2) + "   ";
        }
        if(playerOne.getPosition() == playerTwo.getPosition())
            position[playerOne.getPosition()] =" HC  ";
        else
        {
            position[playerOne.getPosition()] =" H   ";
            position[playerTwo.getPosition()] =" C   ";
        }
        if(playerOne.getPosition() == 0 && playerTwo.getPosition() == 0)
            position[playerOne.getPosition()] ="SHC ";
        else if(playerOne.getPosition() == 0)
            position[playerOne.getPosition()] ="SH  ";
        else if(playerTwo.getPosition() == 0)
            position[playerTwo.getPosition()] ="SC  ";
        for(int i = 0; i <= trailLength  - 1; i++){
            System.out.print(position[i]);
        }
        System.out.println("");
    }

    /**
     * This is a method for player to see animals
     * @param A Player to indicate one of the two players
     */
    public void seeAnimal(Player player)
    {
        int a = 1 + (int)(Math.random() * 2); // to generate random integer number from 1 to 3, can reach 1 but can not reach 3
        int b = 1 + (int)(Math.random() * 5);

        if(player.getPosition() > 0 && player.getPosition() < trailLength - 1)
        {
            if(a == 1)
                switch(b)
                {
                    case 1:System.out.println(player.getPlayerName() + " meet a Koala and gain 10 points");
                    player.setScore(10 + player.getScore());break;
                    case 2:System.out.println(player.getPlayerName() + " meet an Emu and gain 7 points");
                    player.setScore(7 + player.getScore());break;
                    case 3:System.out.println(player.getPlayerName() + " meet a Wombat and gain 5 points");
                    player.setScore(5 + player.getScore());break;
                    case 4:System.out.println(player.getPlayerName() + " meet a Kangaroo and gain 2 points");
                    player.setScore(2 + player.getScore());break;
                    case 5:System.out.println(player.getPlayerName() + " meet a Redback spider and lose 5 points");
                    player.setScore(-5 + player.getScore());break;
                }
            System.out.println(player.getPlayerName() + " now got : " + player.getScore() + " points");
        }
        else
            System.out.println(player.getPlayerName() + " haven't seen any animal.");
    }

    /**
     * This is a method which randomly generates NatureFeatures on trail
     */
    public void generateNatureFeatures()
    {
        natureTrail.setNatureFeature();
        int arr[] = new int[4];
        Random random = new Random(); 
        arr[0] = random.nextInt(trailLength-2) + 1;
        int i = 1;
        while(i <= 3){
            int x = random.nextInt(trailLength-2) + 1;
            for (int j = 0;j <= i - 1;j++){
                if(arr[j] == x)
                    break;// to check whether the ramdon number has occured before
                if(j + 1 == i){
                    arr[i] = x; //to determine which elements is assigned to this new random number
                    i++;
                }
            }
        }
        for(i = 0; i <= 3; i++){
            natureTrail.setFeaturePosition(i,arr[i]);
        }
    }

    /**
     * This is a method for player to meet NatureFeatures
     * @param A Player to indicate one of the two players
     */
    public void meetNatureFeatures(Player player)
    {
        ArrayList<Integer> featurePosition = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            featurePosition.add(natureTrail.getFeaturePosition(i));
        }
        if(featurePosition.contains(player.getPosition()) == true) // contains is a boolean method in Arraylist which will test if arraylist contains some
        //certain elements
        {
            int i = 0;
            i = featurePosition.indexOf(player.getPosition());// give the index of which feature player met
            player.setPosition(natureTrail.getSpacePenalty(i) + player.getPosition());
            System.out.println(player.getPlayerName() + " met " + natureTrail.getFeatureType(i));
            if(natureTrail.getSpacePenalty(i) > 0)
                System.out.println("And will move forward " + natureTrail.getSpacePenalty(i) + " steps");
            else
                System.out.println("And will move backward " + -(natureTrail.getSpacePenalty(i)) + " steps");
            System.out.println(player.getPlayerName() + " is now at positon " + player.getPosition());
        }
        if(player.getPosition() <= 0){
            player.setPosition(0);
            System.out.println(player.getPlayerName() + " is now at start position");
        }
        else
        if(player.getPosition() >= trailLength - 1){
            player.setPosition(trailLength - 1);
            System.out.println(player.getPlayerName() + " is now at end position");
        }
    }
    
    /**
     * This is a method for player to roll dice
     * @param A Player to indicate one of the two players
     */
    public int rollDice(Player player)
    {
        Dice dice = new Dice();
        int diceNumber = dice.acceptDiceNumber();
        System.out.println(player.getPlayerName() + " rolled " +diceNumber);
        return diceNumber; // need return a value ,so that other method can use it for assignment .
    }

    /**
     * This is a method for player to move position on trail
     * @param A Player to indicate one of the two players
     */
    public void movePosition(Player player)
    {
        int stepsToMove = rollDice(player);
        int liveLocation = player.getPosition() + stepsToMove;
        if(liveLocation >= trailLength - 1){
            player.setPosition(trailLength - 1);
            player.setScore(10 + player.getScore());
            System.out.println(player.getPlayerName() + " first arrived end and gain 10 scores");
            System.out.println("Game over");
        }
        else
        {
            player.setPosition(liveLocation);
            System.out.println(player.getPlayerName() + " is now at position " + player.getPosition());
            seeAnimal(player);
            meetNatureFeatures(player);
        }
        displayPosition();
    }

    /**
     * This is a method to press Enter to continue game
     */
    public void inputEnter()
    {
        Scanner enter = new Scanner(System.in);
        System.out.println("Please press Enter to continue game");
        String enter1 = enter.nextLine(); // press Enter will show nothing on terminal 
    }
    
    /**
     * This is a method which determines who plays game first
     * @return The true or false
     */
    public boolean takeFirstTurn()
    {
        int playerOneDice = 0;
        int playerTwoDice = 0;
        do
        {
            playerOneDice = rollDice(playerOne);
            playerTwoDice = rollDice(playerTwo);
            if(playerOneDice == playerTwoDice)
            {
                System.out.println("");
                System.out.println("Same number,dice again");
                System.out.println("");
            }
        }
        while(playerOneDice == playerTwoDice);

        if(playerOneDice > playerTwoDice)
        {
            System.out.println("PlayerOne " + playerOne.getPlayerName() + " will play first");
            System.out.println("");
            return true;
        }
        else
        {
            System.out.println("PlayerTwo Computer will play first");
            System.out.println("");
            return false;
        }
    }

    /**
     * This is a method which let players take turn to play game 
     */
    public void takeTurn()
    {
        Player index[] = {playerOne,playerTwo}; 
        int i = 0;
        if(takeFirstTurn() == true)
            i = 0;
        else
            i = 1;
        while(true){
            if(i == 0)
            {
                inputEnter(); //when playerOne who is human is in the turn , it will request press Enter to continue
            }
            movePosition(index[i]);
            if(playerOne.getPosition() == trailLength - 1 || playerTwo.getPosition() == trailLength - 1)
                break;  // break will stop the loop 
            i = (i+1)%2; // this will give a result of 0 and 1 in turn
        }
    }

    /**
     * This is a method which show the result of game at final
     */
    public void displayResult()
    {
        System.out.println("");
        System.out.println("");
        System.out.println("playerOne got " + playerOne.getScore() + " points");
        System.out.println("playerTwo got " + playerTwo.getScore() + " points");
        if(playerOne.getScore() > playerTwo.getScore())
            System.out.println("PlayerOne " + playerOne.getPlayerName() + " won！");
        else 
        if(playerOne.getScore() < playerTwo.getScore())
            System.out.println("PlayerTwo " + playerTwo.getPlayerName() + " won！");
        else
            System.out.println("Draw  ");
    }

    /**
     * This is a method to start the game
     */
    public void startGame()
    {
        welcomeToGame();
        setTrailLength();
        setPlayerOne();
        setPlayerTwo();
        generateNatureFeatures();  
        inputEnter();
        takeTurn();
        displayResult();
    }

}
