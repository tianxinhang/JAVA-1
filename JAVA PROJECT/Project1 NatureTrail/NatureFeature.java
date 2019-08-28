
/**
 * The class will hold the information of NatureFeature attributes
 *
 * @author TIANXIN HANG
 * @version 2019.04.18
 */
public class NatureFeature
{
    // instance variables - replace the example below with your own
    private int featurePosition;
    private String featureType;
    private int spacePenalty;

    /**
     * Default constructor for objects of class NatureFeature
     */
    public NatureFeature()
    {
        featurePosition = 0;
        featureType = "";
        spacePenalty = 0;
    }

    /**
     * Constructor for objects of class NatureFeature
     */
    public NatureFeature(int newFeaturePosition,String newFeatureType,
    int newSpacePenalty)
    {
        // initialise instance variables
        featurePosition = newFeaturePosition;
        featureType = newFeatureType;
        spacePenalty = newSpacePenalty;

    }

    /**
     * This is an accessor method which gets position of NatureFeature
     * @return The position of NatureFeature
     */
    public int getFeaturePosition()
    {
        return featurePosition;
    }

    /**
     * This is an accessor method which gets type of NatureFeature
     * @return The type of NatureFeature
     */
    public String getFeatureType()
    {
        return featureType;
    }

    /**
     * This is an accessor method which gets penalty of NatureFeature
     * @return The penalty of NatureFeature
     */
    public int getSpacePenalty()
    {
        return spacePenalty;
    }

    /**
     * This is a mututor method which changes position of NatureFeature
     * @param An int to indicate position of NatureFeature
     */
    public void setFeaturePosition(int newFeaturePosition)
    {
        featurePosition = newFeaturePosition;
    }

    /**
     * This is a mututor method which changes type of NatureFeature
     * @param A String to indicate new type of NatureFeature
     */
    public void setFeatureType(String newFeatureType)
    {
        featureType = newFeatureType;
    }

    /**
     * This is a mututor method which changes penalty of NatureFeature
     * @param An int to indicate new penalty of NatureFeature
     */
    public void setSpacePenalty(int newSpacePenalty)
    {
        spacePenalty = newSpacePenalty;
    }
}
