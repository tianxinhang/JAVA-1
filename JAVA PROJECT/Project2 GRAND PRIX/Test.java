
/**
 * The class will test the driver class
 *
 * @author TIANXIN HANG
 * @version 2019.5.30
 */
public class Test
{
    /**
     * Constructor for objects of class Test
     */
    public Test()
    {

    }

    /**
     * This is a method to test the default constructors of the Driver class
     *
     */
    public void testDefaultConstructors()
    {
        Driver test = new Driver();
        test.setDriverName("Ben");
        if (test.getDriverName().equals("Ben"))
        {    
            System.out.println("Name setting is working");
        }

        test.setRanking(3);
        if (test.getRanking() == 3)
        {
            System.out.println("Ranking setting is working");
        }

        test.setSpecialSkill("Overtaking");
        if (test.getSpecialSkill().equals("Overtaking"))
        {
            System.out.println("Special skill setting is working");
        }

        test.setEligibleToRace(false);
        if (test.getEligibleToRace() == false)
        {
            System.out.println("EligibleToRace set is working");
        }

        test.setAccumulatedScore(10);
        if (test.getAccumulatedScore() == 10)
        {
            System.out.println("AccumulatedScore set is working");
        }

        test.setAccumulatedTime(100);
        if (test.getAccumulatedTime() == 100)
        {
            System.out.println("AccumulatedTime set is working");
        }

        test.setTyresType("wet");
        if (test.getTyresType().equals("wet"))
        {
            System.out.println("Tyre set is working");
        }

        test.reSetAccumulatedTime();
        if (test.getAccumulatedTime() == 0)
        {
            System.out.println("AccumulatedTime reset is working");
        }

        test.reSetEligibleToRace();
        if (test.getEligibleToRace() == true)
        {
            System.out.println("EligibleToRace reset is working");
        }
    }
}
